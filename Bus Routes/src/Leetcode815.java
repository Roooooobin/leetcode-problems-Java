import java.util.*;

public class Leetcode815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) {
            return 0;
        }
        int n = routes.length;
        HashMap<Integer, HashSet<Integer>> route2Bus = new HashMap<>();
        HashSet<Integer>[] bus2Routes = new HashSet[n];
        for (int i = 0; i < bus2Routes.length; i++) {
            bus2Routes[i] = new HashSet<>();
        }
        for (int i = 0; i < routes.length; i++) {
            for (int x : routes[i]) {
                HashSet<Integer> l = route2Bus.getOrDefault(x, new HashSet<>());
                l.add(i);
                route2Bus.put(x, l);
                bus2Routes[i].add(x);
            }
        }
        // no bus could reach target, return -1
        if (!route2Bus.containsKey(target)) {
            return -1;
        }
        Deque<int[]> q = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();
        for (Integer bus : route2Bus.get(source)) {
            q.offerLast(new int[] {bus, 1});
        }
        int res = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] front = q.pollFirst();
            int bus = front[0], step = front[1];
            seen.add(bus);
            if (route2Bus.get(target).contains(bus)) {
                res = Math.min(res, step);
                continue;
            }
            for (int nextBus = 0; nextBus < n; nextBus++) {
                if (!seen.contains(nextBus)) {
                    HashSet<Integer> cur = new HashSet<>(bus2Routes[bus]);
                    HashSet<Integer> next = bus2Routes[nextBus];
                    cur.retainAll(next);
                    if (cur.size() != 0) {
                        q.offerLast(new int[] {nextBus, step + 1});
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) {
                return 0;
            }

            int n = routes.length;
            boolean[][] edge = new boolean[n][n];
            Map<Integer, List<Integer>> rec = new HashMap<Integer, List<Integer>>();
            for (int i = 0; i < n; i++) {
                for (int site : routes[i]) {
                    List<Integer> list = rec.getOrDefault(site, new ArrayList<Integer>());
                    for (int j : list) {
                        edge[i][j] = edge[j][i] = true;
                    }
                    list.add(i);
                    rec.put(site, list);
                }
            }

            int[] dis = new int[n];
            Arrays.fill(dis, -1);
            Queue<Integer> que = new LinkedList<Integer>();
            for (int bus : rec.getOrDefault(source, new ArrayList<Integer>())) {
                dis[bus] = 1;
                que.offer(bus);
            }
            while (!que.isEmpty()) {
                int x = que.poll();
                for (int y = 0; y < n; y++) {
                    if (edge[x][y] && dis[y] == -1) {
                        dis[y] = dis[x] + 1;
                        que.offer(y);
                    }
                }
            }

            int ret = Integer.MAX_VALUE;
            for (int bus : rec.getOrDefault(target, new ArrayList<Integer>())) {
                if (dis[bus] != -1) {
                    ret = Math.min(ret, dis[bus]);
                }
            }
            return ret == Integer.MAX_VALUE ? -1 : ret;
        }
    }

    /*
    作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/bus-routes/solution/gong-jiao-lu-xian-by-leetcode-solution-yifz/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    */
}
