public class Leetcode2090 {

    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int[] res = new int[n];
        int div = 2 * k + 1;
        for (int i = 0; i < n; i++) {
            if (i - k < 0 || i + k > n - 1) {
                res[i] = -1;
                continue;
            }
            res[i] = (int) ((prefixSum[i + k + 1] - prefixSum[i - k]) / div);
        }
        return res;
    }
}
