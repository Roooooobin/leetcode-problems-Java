public class Leetcode1894 {

    public int chalkReplacer(int[] chalk, int k) {

        int n = chalk.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];
        for (int i = 1; i < chalk.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + chalk[i];
        }
        long remaining = k % prefixSum[n - 1];
        if (remaining == 0) {
            return 0;
        }
        return upperBound(prefixSum, 0, prefixSum.length - 1, remaining);
    }

    public int upperBound(long[] nums, int l, int r, long tar) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] <= tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
