public class Leetcode905 {

    public int[] sortArrayByParity(int[] nums) {

        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 0) {
                i++;
            }
            while (i < j && (nums[j] & 1) == 1) {
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
        return nums;
    }
}
