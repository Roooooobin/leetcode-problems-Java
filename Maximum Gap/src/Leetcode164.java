import java.util.Arrays;

public class Leetcode164 {

    public int maximumGap(int[] nums) {

        // radix sort
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        long exp = 1;
        int[] tmp = new int[n];

        while (exp <= max) {

            int[] digits = new int[10];
            // current digit
            for (int num : nums) {
                digits[(num / (int) exp) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                digits[i] += digits[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                tmp[digits[digit] - 1] = nums[i];
                digits[digit]--;
            }
            System.arraycopy(tmp, 0, nums, 0, n);
            exp *= 10;
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
