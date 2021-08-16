import java.util.Arrays;

public class Leetcode462 {

    public int minMoves2(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int dest;
        if (n % 2 == 0) {
            dest = (nums[n / 2] + nums[n / 2 - 1]) >> 1;
        } else {
            dest = nums[n / 2];
        }
        int res = 0;
        for (int num : nums) {
            if (num < dest) {
                res += dest = num;
            } else {
                res += num - dest;
            }
        }
        return res;
    }
}
