public class Leetcode413 {

    public int numberOfArithmeticSlices(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int diff = nums[j] - nums[i];
            int k = j + 1;
            while (k < nums.length && nums[k] - nums[j] == diff) {
                j++;
                k++;
            }
            res += (j - i - 1);
        }

        return res;
    }
}
