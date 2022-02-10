import java.util.Arrays;

public class Leetcode1984 {

    class Solution {
        public int minimumDifference(int[] nums, int k) {

            Arrays.sort(nums);
            int res = Integer.MAX_VALUE;
            for (int i = 0; i <= nums.length - k; i++) {
                res = Math.min(res, nums[i + k - 1] - nums[i]);
            }
            return res;
        }
    }
}
