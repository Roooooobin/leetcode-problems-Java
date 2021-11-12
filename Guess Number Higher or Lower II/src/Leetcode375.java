public class Leetcode375 {

    /*
    https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/cai-shu-zi-da-xiao-ii-by-leetcode-soluti-a7vg/
     */
    public int getMoneyAmount(int n) {

        final int MAX = 0x3f3f3f3f;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = MAX;
                for (int k = i; k < j; k++) {
                    int cur = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    min = Math.min(min, cur);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }
}
