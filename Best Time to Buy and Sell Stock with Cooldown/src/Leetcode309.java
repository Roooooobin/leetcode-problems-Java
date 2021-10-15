public class Leetcode309 {
    // dp0Pre to represent dp[i-2][0]
    public int maxProfit(int[] prices) {
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        int dp0Pre = 0;
        for (int price : prices) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, dp0Pre - price);
            dp0Pre = tmp;
        }
        return dp0;
    }

    public int maxProfit(int[] prices) {

        int n = prices.length;
        /*
        dp[i][0] with stock
        dp[i][1] without stock and in cooldown
        dp[i][2] without stock and not in cooldown
         */
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
