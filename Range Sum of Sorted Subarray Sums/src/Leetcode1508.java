import java.util.Arrays;

public class Leetcode1508 {

    final int MOD = 1_000_000_007;

    public int rangeSum(int[] nums, int n, int left, int right) {

        long res = 0;
        int[] sum = new int[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[idx++] = nums[i];
            int cur = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                cur += nums[j];
                sum[idx++] = cur;
            }
        }
        Arrays.sort(sum);
        for (int i = left - 1; i <= right - 1; i++) {
            res += sum[i];
            res %= MOD;
        }
        return (int) res;
    }
}
