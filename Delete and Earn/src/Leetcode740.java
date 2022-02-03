public class Leetcode740 {

    class Solution {
        public int deleteAndEarn(int[] nums) {

            int[] a = new int[10003];
            for (int num : nums) {
                a[num] += num;
            }
            int[] dp = new int[10003];
            dp[0] = 0;
            dp[1] = a[1];
            for (int i = 2; i < a.length; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + a[i]);
            }
            return dp[dp.length - 1];
        }
    }
}
