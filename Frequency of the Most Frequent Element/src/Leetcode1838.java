import java.util.Arrays;

public class Leetcode1838 {

    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);
        int l = 0;
        int res = 1;
        long tot = 0;
        for (int r = 1; r < nums.length; ++r) {

            tot += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (tot > k) {
                tot -= (nums[r] - nums[l]);
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
