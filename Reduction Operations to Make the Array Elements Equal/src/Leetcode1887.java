import java.util.Arrays;

public class Leetcode1887 {
    class Solution {
        //        public int reductionOperations(int[] nums) {
        //
        //            int res = 0;
        //            int op = 0;
        //            int i = 1;
        //            Arrays.sort(nums);
        //            while (i < nums.length) {
        //                while (i < nums.length && nums[i] == nums[i - 1]) {
        //                    ++i;
        //                    res += op;
        //                }
        //                if (i == nums.length) break;
        //                ++i;
        //                ++op;
        //                res += op;
        //            }
        //            return res;
        //        }

        public int reductionOperations(int[] nums) {

            int res = 0;
            int op = 0;
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    ++op;
                }
                res += op;
            }
            return res;
        }
    }
}
