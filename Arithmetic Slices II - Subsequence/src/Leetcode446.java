import java.util.HashMap;

/*
https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/solution/deng-chai-shu-lie-hua-fen-ii-zi-xu-lie-b-77pl/
 */
public class Leetcode446 {

    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;
        // dp[i][diff]表示差为diff的弱等差子序列（长度为2的等差序列）
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                int cnt = dp[j].getOrDefault(diff, 0);
                res += cnt;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + cnt + 1);
            }
        }

        return res;
    }
}
