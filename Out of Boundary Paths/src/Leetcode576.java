public class Leetcode576 {

    public int findPaths(int m, int n, int k, int r, int c) {

        if (k == 0) {
            return 0;
        }
        int[][][] dp = new int[m + 2][n + 2][k + 1];
        dp[r + 1][c + 1][0] = 1;
        final int mod = 1000000007;
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int t = 1; t <= k; t++) {
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int[] direction : directions) {
                        int ni = i + direction[0], nj = j + direction[1];
                        dp[ni][nj][t] = (dp[ni][nj][t] % mod + dp[i][j][t - 1] % mod) % mod;
                    }
                }
            }
        }
        int res = 0;
        for (int t = 1; t <= k; t++) {
            for (int i = 0; i <= m; i++) {
                res = (res % mod + dp[i][0][t] % mod) % mod;
                res = (res % mod + dp[i][n + 1][t] % mod) % mod;
            }
        }
        for (int t = 1; t <= k; t++) {
            for (int j = 0; j <= n; j++) {
                res = (res % mod + dp[0][j][t] % mod) % mod;
                res = (res % mod + dp[m + 1][j][t] % mod) % mod;
            }
        }
        return res;
    }

    class Solution {

        public int findPaths(int m, int n, int k, int r, int c) {

            if (k == 0) {
                return 0;
            }
            int[][] dp = new int[m][n];
            dp[r][c] = 1;
            final int mod = 1000000007;
            int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int res = 0;
            for (int t = 1; t <= k; t++) {
                int[][] dpNew = new int[m + 2][n + 2];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int count = dp[i][j];
                        for (int[] direction : directions) {
                            int ni = i + direction[0], nj = j + direction[1];
                            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                                dpNew[ni][nj] = (dpNew[ni][nj] + count) % mod;
                                // 出界，累加
                            } else {
                                res = (res + count) % mod;
                            }
                        }
                    }
                }
                dp = dpNew;
            }

            return res;
        }
    }
}
