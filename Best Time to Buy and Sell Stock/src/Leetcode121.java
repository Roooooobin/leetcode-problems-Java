public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (min > price) min = price;
            else max = Math.max(max, price - min);
        }
        return max;
    }
}
