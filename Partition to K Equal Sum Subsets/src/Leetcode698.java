import java.util.Arrays;

public class Leetcode698 {

    int[] a;
    int target;
    boolean flag = false;
    int K;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int total = Arrays.stream(nums).sum();
        if (total % k != 0) {
            return false;
        }
        a = nums;
        target = total / k;
        K = k;
        int max = Arrays.stream(nums).max().getAsInt();
        if (max > target) {
            return false;
        }
        dfs(0, new int[k]);
        return flag;
    }

    public void dfs(int idx, int[] cur) {
        if (flag) {
            return;
        }
        if (idx == a.length) {
            int i = 0;
            for (; i < K; i++) {
                if (cur[i] != target) {
                    break;
                }
            }
            flag = i == K;
            return;
        }
        for (int i = 0; i <= Math.min(K - 1, idx); i++) {
            if (cur[i] + a[idx] <= target) {
                cur[i] += a[idx];
                dfs(idx + 1, cur);
                cur[i] -= a[idx];
            }
        }
    }
}
