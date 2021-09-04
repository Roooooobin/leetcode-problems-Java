public class Leetcode813 {

    public double largestSumOfAverages(int[] nums, int K) {

        int n = nums.length;
        double[] prefixSum = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        double[][] dp = new double[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefixSum[i] / i;
            for (int k = 2; k <= K && k <= i; k++) {
                for (int j = 1; j < i; j++) {
                    dp[i][k] =
                            Math.max(
                                    dp[i][k],
                                    dp[j][k - 1] + (prefixSum[i] - prefixSum[j]) / (i - j));
                }
            }
        }
        return dp[n][K];
    }
}
