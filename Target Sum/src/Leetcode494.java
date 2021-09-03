public class Leetcode494 {

    int res = 0;
    int[] prefixSum;

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        dfs(nums, target, 0);
        return res;
    }

    public void dfs(int[] a, int tar, int idx) {

        int n = a.length;
        if (idx == n && tar == 0) {
            res++;
            return;
        }
        // impossible, prune
        int remainingMax = prefixSum[n] - prefixSum[idx];
        if (tar > remainingMax || tar < -remainingMax) {
            return;
        }
        dfs(a, tar + a[idx], idx + 1);
        dfs(a, tar - a[idx], idx + 1);
    }
}
