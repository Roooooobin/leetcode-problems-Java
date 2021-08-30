public class Leetcode1690 {

    public int stoneGameVII(int[] stones) {

        int n = stones.length;
        int[] prefixSum = new int[n + 1];
        int[][] dp = new int[n][n];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int pickI = prefixSum[j + 1] - prefixSum[i + 1] - dp[i + 1][j];
                int pickJ = prefixSum[j] - prefixSum[i] - dp[i][j - 1];
                dp[i][j] = Math.max(pickI, pickJ);
            }
        }
        //        for (int i = 0; i < n; i++) {
        //            for (int j = 0; j < n; j++) {
        //                System.out.println(String.format("%d %d %d", i, j, dp[i][j]));
        //            }
        //        }
        return dp[0][n - 1];
    }
}
