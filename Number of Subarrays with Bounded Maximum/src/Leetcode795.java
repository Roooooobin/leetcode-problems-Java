public class Leetcode795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        int res = 0;
        int inIdx = -1, largerIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                res += (i - largerIdx);
                inIdx = i;
            } else if (nums[i] < left) {
                res += (Math.max(inIdx - largerIdx, 0));
            } else {
                largerIdx = i;
            }
        }
        return res;
    }

    class Solution {

        public int numSubarrayBoundedMax(int[] nums, int left, int right) {

            return helper(nums, right + 1) - helper(nums, left);
        }

        public int helper(int[] a, int max) {

            int res = 0;
            int cur = 0;
            for (int x : a) {
                if (x < max) {
                    cur++;
                    res += cur;
                } else {
                    cur = 0;
                }
            }

            return res;
        }
    }
}
