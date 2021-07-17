public class Leetcodejianzhi42 {

    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int curSum = 0;
        for (int num : nums) {
            curSum += num;
            maxSum = Math.max(curSum, maxSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {

        int maxSum = nums[0];
        int curSum = 0;
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
