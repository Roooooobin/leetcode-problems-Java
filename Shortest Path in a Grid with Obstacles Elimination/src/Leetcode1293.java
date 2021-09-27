import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Leetcode1293 {

    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    //    public static void main(String[] args) {
    //        int[][] a = new int[][] {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
    //        Leetcode1293 ins = new Leetcode1293();
    //        System.out.println(ins.shortestPath(a, 1));
    //    }

    public int shortestPath(int[][] grid, int K) {

        int res = 0x3f3f3f3f;
        int m = grid.length, n = grid[0].length;
        if (K >= m + n - 2) {
            return m + n - 2;
        }
        // int[]{i, j, k, step}
        Deque<int[]> q = new ArrayDeque<>();
        // key: i+j+k
        HashSet<String> seen = new HashSet<>();
        int[] start;
        if (grid[0][0] == 1) {
            start = new int[] {0, 0, 1, 0};
        } else {
            start = new int[] {0, 0, 0, 0};
        }
        q.offerLast(start);
        seen.add(makeKey(start[0], start[1], start[2]));
        while (!q.isEmpty()) {
            int[] front = q.pollFirst();
            int i = front[0], j = front[1];
            int k = front[2], step = front[3];
            if (i == m - 1 && j == n - 1 && k <= K) {
                res = Math.min(res, step);
                continue;
            }
            if (step >= res || k > K) {
                continue;
            }
            for (int[] direction : directions) {
                int nextI = i + direction[0], nextJ = j + direction[1];
                String key = makeKey(nextI, nextJ, k);
                if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !seen.contains(key)) {
                    seen.add(key);
                    if (grid[nextI][nextJ] == 1) {
                        q.offerLast(new int[] {nextI, nextJ, k + 1, step + 1});
                    } else {
                        q.offerLast(new int[] {nextI, nextJ, k, step + 1});
                    }
                }
            }
        }
        if (res == 0x3f3f3f3f) {
            return -1;
        }
        return res;
    }

    public String makeKey(int i, int j, int k) {
        return i + "|" + j + "|" + k;
    }

    // WA
    // (0, 0) -> (m-1, n-1)
    //    public int shortestPath(int[][] grid, int K) {
    //
    //        final int MAX = 0x3f3f3f3f;
    //        int m = grid.length, n = grid[0].length;
    //        int res = MAX;
    //        int[][][] dp = new int[m + 1][n + 1][K + 1];
    //        for (int k = 0; k <= K; k++) {
    //            for (int i = 0; i <= m; i++) {
    //                for (int j = 0; j <= n; j++) {
    //                    dp[i][j][k] = MAX;
    //                }
    //            }
    //        }
    //        if (grid[0][0] == 0) {
    //            dp[1][1][0] = 0;
    //        }
    //        dp[1][1][1] = 0;
    //        for (int k = 1; k <= K; k++) {
    //            for (int i = 1; i <= m; i++) {
    //                for (int j = 1; j <= n; j++) {
    //                    if (grid[i - 1][j - 1] == 0) {
    //                        dp[i][j][k - 1] =
    //                                Math.min(
    //                                        dp[i][j][k - 1],
    //                                        Math.min(dp[i - 1][j][k - 1], dp[i][j - 1][k - 1]) +
    // 1);
    //                        dp[i][j][k] =
    //                                Math.min(
    //                                        dp[i][j][k],
    //                                        Math.min(dp[i - 1][j][k], dp[i][j - 1][k]) + 1);
    //                    } else {
    //                        dp[i][j][k] =
    //                                Math.min(
    //                                        dp[i][j][k],
    //                                        Math.min(dp[i - 1][j][k - 1], dp[i][j - 1][k - 1]) +
    // 1);
    //                    }
    //                }
    //            }
    //        }
    //        for (int k = 0; k <= K; k++) {
    //            res = Math.min(res, dp[m][n][k]);
    //        }
    //        if (res == MAX) {
    //            return -1;
    //        }
    //        return res;
    //    }
}
