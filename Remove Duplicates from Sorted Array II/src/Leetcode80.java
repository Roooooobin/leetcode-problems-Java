public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int x: nums) {
            if (i < 2 || x > nums[i-2]) {
                nums[i++] = x;
            }
        }
        return i;
    }
}
