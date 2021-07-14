import java.util.Arrays;

public class Leetcode1818 {

    private static final int MOD = (int) 1e9 + 7;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int[] sortedNums1 = new int[n];
        for (int i = 0; i < n; i++) {
            sortedNums1[i] = nums1[i];
        }
        Arrays.sort(sortedNums1);

        long sum = 0;
        long maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]) % MOD;
            sum = (sum + diff) % MOD;
            int idx = lowerBound(sortedNums1, nums2[i]);
            if (idx < n) {
                maxDiff = Math.max(maxDiff, diff - (sortedNums1[idx] - nums2[i]));
            }
            if (idx > 0) {
                maxDiff = Math.max(maxDiff, diff - (nums2[i] - sortedNums1[idx - 1]));
            }
        }

        return (int) ((sum - maxDiff + MOD) % MOD);
    }

    public int lowerBound(int[] nums, int tar) {

        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < tar) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
