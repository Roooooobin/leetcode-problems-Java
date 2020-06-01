public class Leetcode122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int i = 1;
        int ans = 0;
        while (i < n) {
            while (i < n && prices[i-1] >= prices[i]) ++i;
            int min = prices[i-1];
            while (i < n && prices[i-1] <= prices[i]) ++i;
            int max = prices[i-1];
            ans += max - min;
        }
        return ans;
    }
}
