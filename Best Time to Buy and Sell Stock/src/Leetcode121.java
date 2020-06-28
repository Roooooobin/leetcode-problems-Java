public class Leetcode121 {
    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (min > price) min = price;
            else max = Math.max(max, price - min);
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int dp0 = 0, dp1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp0 = Math.max(dp0, dp1 + price);
            dp1 = Math.max(dp1, -price);
        }
        return dp0;
    }
}
