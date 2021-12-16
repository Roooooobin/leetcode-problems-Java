import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// TLE
// public class Leetcode310 {
//
//    // TLE
//    int minimum;
//
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//
//        minimum = n;
//        HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
//        for (int[] edge : edges) {
//            int v1 = edge[0], v2 = edge[1];
//            ArrayList<Integer> l = m.getOrDefault(v1, new ArrayList<>());
//            l.add(v2);
//            m.put(v1, l);
//            ArrayList<Integer> l2 = m.getOrDefault(v2, new ArrayList<>());
//            l2.add(v1);
//            m.put(v2, l2);
//        }
//        ArrayList<Integer> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            int h = calcHeight(m, i);
//            if (h == minimum) {
//                res.add(i);
//            } else if (h < minimum) {
//                res.clear();
//                res.add(i);
//                minimum = h;
//            }
//        }
//        return res;
//    }
//
//    public int calcHeight(HashMap<Integer, ArrayList<Integer>> m, int v1) {
//
//        HashSet<Integer> seen = new HashSet<>();
//        seen.add(v1);
//        int height = 0;
//        Deque<Integer> q = new ArrayDeque<>();
//        q.add(v1);
//        while (!q.isEmpty()) {
//            int count = q.size();
//            height++;
//            if (height > minimum) {
//                return minimum + 1;
//            }
//            for (int i = 0; i < count; i++) {
//                int v = q.pollFirst();
//                seen.add(v);
//                ArrayList<Integer> l = m.getOrDefault(v, new ArrayList<>());
//                for (Integer x : l) {
//                    if (!seen.contains(x)) {
//                        q.offerLast(x);
//                        seen.add(x);
//                    }
//                }
//            }
//        }
//        return height;
//    }
// }

/*
https://leetcode-cn.com/problems/minimum-height-trees/solution/zui-rong-yi-li-jie-de-bfsfen-xi-jian-dan-zhu-shi-x/
 */
public class Leetcode310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        ArrayList<ArrayList<Integer>> m = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            m.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int v1 = edge[0], v2 = edge[1];
            degree[v1]++;
            degree[v2]++;
            m.get(v1).add(v2);
            m.get(v2).add(v1);
        }
        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                q.offerFirst(i);
            }
        }
        while (!q.isEmpty()) {
            res = new ArrayList<>();
            int count = q.size();
            for (int i = 0; i < count; i++) {
                int cur = q.pollFirst();
                res.add(cur);
                ArrayList<Integer> l = m.get(cur);
                for (int x : l) {
                    degree[x]--;
                    if (degree[x] == 1) {
                        q.offerLast(x);
                    }
                }
            }
        }
        return res;
    }
}
