public class Leetcode1646 {

    public int getMaximumGenerated(int n) {

        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 1) {
                dp[i] = dp[i / 2] + dp[(i + 1) / 2];
            } else {
                dp[i] = dp[i / 2];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
