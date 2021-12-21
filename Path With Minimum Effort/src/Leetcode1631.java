import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Leetcode1631 {

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length, n = heights[0].length;
        int lo = 0, hi = 0x3f3f3f3f;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (bfs(heights, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public boolean bfs(int[][] a, int effort) {

        int m = a.length, n = a[0].length;
        Deque<Integer> q = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();
        q.add(0);
        seen.add(0);
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            int curX = cur / n, curY = cur % n;
            for (int[] direction : directions) {
                int nextX = curX + direction[0], nextY = curY + direction[1];
                int next = nextX * n + nextY;
                if (!seen.contains(next) && inside(nextX, nextY, m, n)) {
                    int neededEffort = Math.abs(a[nextX][nextY] - a[curX][curY]);
                    if (effort >= neededEffort) {
                        seen.add(next);
                        q.add(next);
                    }
                }
            }
        }
        return seen.contains(m * n - 1);
    }

    public boolean inside(int x, int y, int m, int n) {

        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
