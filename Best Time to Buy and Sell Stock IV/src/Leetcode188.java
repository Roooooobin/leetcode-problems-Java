public class Leetcode188 {
    public int maxProfitInfinityK(int[] prices) {
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, tmp - price);
        }
        return dp0;
    }

    public int maxProfit(int maxK, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        if (maxK > n / 2) return maxProfitInfinityK(prices);
        int[][][] dp = new int[n][maxK+1][2];
        for (int i=0; i<n; ++i) {
            for (int k=maxK; k>=1; --k) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n-1][maxK][0];
    }
}
