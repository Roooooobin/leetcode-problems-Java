public class Leetcode645 {

    public int[] findErrorNums(int[] nums) {

        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                res[0] = Math.abs(nums[i]);
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }
}
