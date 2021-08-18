public class Leetcode1685 {

    public int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] =
                    (i * nums[i] - (sum[i] - nums[i]))
                            + (sum[n - 1] - sum[i] - (n - i - 1) * nums[i]);
        }
        return res;
    }
}
