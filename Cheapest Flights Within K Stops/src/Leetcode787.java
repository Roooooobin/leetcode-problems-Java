import java.util.Arrays;

/*
https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/solution/k-zhan-zhong-zhuan-nei-zui-bian-yi-de-ha-abzi/
 */
public class Leetcode787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        final int MAX = Integer.MAX_VALUE >> 1;
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dp[i], MAX);
        }
        dp[0][src] = 0;
        for (int t = 1; t <= k + 1; t++) {

            for (int[] flight : flights) {
                int i = flight[0], j = flight[1], price = flight[2];
                dp[t][j] = Math.min(dp[t][j], dp[t - 1][i] + price);
            }
        }
        int res = MAX;
        for (int t = 1; t <= k + 1; t++) {
            res = Math.min(res, dp[t][dst]);
        }
        return res == MAX ? -1 : res;
    }
}
