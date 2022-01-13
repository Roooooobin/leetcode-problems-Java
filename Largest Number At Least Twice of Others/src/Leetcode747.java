public class Leetcode747 {

    class Solution {
        public int dominantIndex(int[] nums) {

            if (nums.length == 1) {
                return 0;
            }
            int max = nums[0], maxIdx = 0;
            int secondMax = Integer.MIN_VALUE;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    secondMax = max;
                    max = nums[i];
                    maxIdx = i;
                } else if (nums[i] > secondMax) {
                    secondMax = nums[i];
                }
            }
            if (max < 2 * secondMax) {
                return -1;
            } else {
                return maxIdx;
            }
        }
    }
}
