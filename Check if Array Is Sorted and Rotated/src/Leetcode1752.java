public class Leetcode1752 {

    class Solution {
        public boolean check(int[] nums) {

            int n = nums.length;
            int i;
            for (i = 1; i < n; ++i) {
                if (nums[i] < nums[i - 1]) {
                    break;
                }
            }
            if (i == n) {
                return true;
            }
            int rotatedIdx;
            for (rotatedIdx = i + 1; rotatedIdx < n; ++rotatedIdx) {
                if (nums[rotatedIdx] < nums[rotatedIdx - 1]) {
                    break;
                }
            }
            if (rotatedIdx != n) {
                return false;
            } else {
                return nums[n - 1] <= nums[0];
            }
        }
    }
}
