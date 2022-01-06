public class Leetcode312 {

    /*
    https://leetcode-cn.com/problems/burst-balloons/solution/zhe-ge-cai-pu-zi-ji-zai-jia-ye-neng-zuo-guan-jian-/
     */
    public int maxCoins(int[] nums) {

        // k是(i, j)之间最后一个被戳爆的气球
        // total = dp[i][k] + nums[i] * nums[k] * nums[j] + dp[k][j]
        int n = nums.length;
        //
        int[] a = new int[n + 2];
        a[0] = 1;
        a[n + 1] = 1;
        System.arraycopy(nums, 0, a, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        // k is the length(i, j)
        for (int len = 3; len <= n + 2; len++) {
            for (int i = 0; i <= n + 2 - len; i++) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k++) {
                    int l = dp[i][k];
                    int r = dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], l + r + a[i] * a[k] * a[j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
