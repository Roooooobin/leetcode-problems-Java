public class Leetcode377 {

    public int combinationSum4(int[] candidates, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int x : candidates) {
                if (i >= x) {
                    dp[i] += dp[i - x];
                }
            }
        }
        return dp[target];
    }
}
