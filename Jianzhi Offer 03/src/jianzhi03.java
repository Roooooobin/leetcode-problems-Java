public class jianzhi03 {

    public int findRepeatNumber(int[] nums) {

        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] *= -1;
        }
        return 0;
    }
}
