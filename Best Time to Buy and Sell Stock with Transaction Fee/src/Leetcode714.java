public class Leetcode714 {
    public int maxProfit(int[] prices, int fee) {
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, tmp - price - fee);
        }
        return dp0;
    }
}
