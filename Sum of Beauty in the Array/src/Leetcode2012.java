public class Leetcode2012 {

    // use min heap will TLE
    public int sumOfBeauties(int[] nums) {

        int res = 0;
        int n = nums.length;
        // maintain the min value after nums[i]
        int[] postMins = new int[n];
        int preMin = nums[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            postMins[i] = preMin;
            preMin = Math.min(preMin, nums[i]);
        }
        int preMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            // check if 2 is possible
            if (nums[i] > preMax && nums[i] < postMins[i]) {
                res += 2;
            }
            // check if 1 is possible
            else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                res += 1;
            }
            preMax = Math.max(preMax, nums[i]);
        }
        return res;
    }
}
