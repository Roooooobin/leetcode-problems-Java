public class Leetcode877 {
    class Solution {
        public boolean stoneGame(int[] piles) {

            int n = piles.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < piles.length; i++) {
                dp[i][i] = piles[i];
            }
            for (int i = n - 2; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    int pickI = piles[i] - dp[i + 1][j];
                    int pickJ = piles[j] - dp[i][j - 1];
                    dp[i][j] = Math.max(pickI, pickJ);
                }
            }
            return dp[0][n - 1] > 0;
        }

        // 先手永远可以获胜- -
        // return true
    }
}
