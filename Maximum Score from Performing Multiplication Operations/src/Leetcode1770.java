public class Leetcode1770 {

    /*
    https://leetcode-cn.com/problems/maximum-score-from-performing-multiplication-operations/solution/java-dpjie-fa-by-sadfriedrice-8su0/
     */

    public int maximumScore(int[] nums, int[] multipliers) {

        int n = nums.length;
        int m = multipliers.length;
        // dp[i][j] i表示左边选i个数的最大值，j表示右边选j个数的最大值
        int[][] dp = new int[m + 1][m + 1];
        dp[1][0] = nums[0] * multipliers[0];
        dp[0][1] = nums[n - 1] * multipliers[0];
        // 左右总共选i个，然后枚举l个左边和i-l个右边
        for (int i = 2; i <= m; i++) {
            int mul = multipliers[i - 1];
            for (int l = 0; l <= i; l++) {
                int r = i - l;
                int idx = n - r;
                if (l == 0) {
                    dp[l][r] = dp[l][r - 1] + mul * nums[idx];
                    continue;
                }
                if (r == 0) {
                    dp[l][r] = dp[l - 1][r] + mul * nums[l - 1];
                    continue;
                }
                dp[l][r] = dp[l - 1][r] + mul * nums[l - 1];
                dp[l][r] = Math.max(dp[l][r], dp[l][r - 1] + mul * nums[idx]);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            res = Math.max(dp[i][m - i], res);
        }
        return res;
    }
}
