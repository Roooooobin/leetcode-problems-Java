import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Leetcode1036 {

    /*
    https://leetcode-cn.com/problems/escape-a-large-maze/solution/gong-shui-san-xie-bfs-gei-ding-zhang-ai-8w63o/
     */
    // 从起点和终点分别出发，如果都能访问至少MAX点，说明必然连通
    class Solution {

        HashSet<Long> blocks = new HashSet<>();
        int n = 1000000;
        int MAX = 100000;
        long BASE = (long) 1e6;
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

            if (blocked.length == 0) {
                return true;
            }
            for (int[] b : blocked) {
                blocks.add(b[0] * BASE + b[1]);
            }
            MAX = blocked.length * (blocked.length - 1) / 2;
            return bfs(source, target) && bfs(target, source);
        }

        public boolean bfs(int[] st, int[] ed) {

            HashSet<Long> seen = new HashSet<>();
            Deque<int[]> q = new ArrayDeque<>();
            q.add(st);
            seen.add(st[0] * BASE + st[1]);
            while (!q.isEmpty() && seen.size() <= MAX) {

                int[] front = q.pollFirst();
                int x = front[0], y = front[1];
                if (x == ed[0] && y == ed[1]) {
                    return true;
                }
                for (int[] direction : directions) {
                    int nx = x + direction[0], ny = y + direction[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    long hash = nx * BASE + ny;
                    if (blocks.contains(hash) || seen.contains(hash)) {
                        continue;
                    }
                    q.offerLast(new int[] {nx, ny});
                    seen.add(hash);
                }
            }
            return seen.size() > MAX;
        }
    }
}
