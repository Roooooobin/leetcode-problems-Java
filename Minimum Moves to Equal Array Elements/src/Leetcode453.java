public class Leetcode453 {

    public int minMoves(int[] nums) {

        int min = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }

        return sum - nums.length * min;
    }
}
