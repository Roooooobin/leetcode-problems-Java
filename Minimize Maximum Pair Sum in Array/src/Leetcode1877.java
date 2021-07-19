import java.util.Arrays;

public class Leetcode1877 {

    public int minPairSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n / 2; ++i) {
            res = Math.max(res, nums[i] + nums[n - i - 1]);
        }
        return res;
    }
}
