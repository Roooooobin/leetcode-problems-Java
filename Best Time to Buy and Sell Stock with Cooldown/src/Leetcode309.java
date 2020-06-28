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
}
