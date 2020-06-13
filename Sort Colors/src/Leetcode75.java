public class Leetcode75 {
    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                ++low;
                ++mid;
            }
            else if (nums[mid] == 1) {
                ++mid;
            }
            else {
                swap(mid, high, nums);
                --high;
            }
        }
    }
}
