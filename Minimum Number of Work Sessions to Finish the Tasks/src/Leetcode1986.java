import java.util.Arrays;

public class Leetcode1986 {

    int[] tasks;
    int sessionTime;
    boolean flag = false;

    public int minSessions(int[] tasks_, int sessionTime_) {

        tasks = tasks_;
        sessionTime = sessionTime_;
        for (int i = 1; i <= tasks.length; i++) {
            flag = false;
            dfs(new int[i], 0);
            if (flag) {
                return i;
            }
        }
        return tasks.length;
    }

    public void dfs(int[] a, int idx) {

        if (idx == tasks.length) {
            flag = true;
            return;
        }
        // 这一步剪枝很关键，第idx的任务只需要遍历idx之前的sessions
        for (int i = 0; i < Math.min(idx + 1, a.length); i++) {
            if (a[i] + tasks[idx] <= sessionTime) {
                a[i] += tasks[idx];
                dfs(a, idx + 1);
                a[i] -= tasks[idx];
            }
        }
    }

    // 状压dp
    // 二进制位值为1表示该工人工作
    class Solution {

        public int minSessions(int[] tasks, int sessionTime) {

            int n = tasks.length;
            int m = 1 << n;
            int[] dp = new int[m];
            Arrays.fill(dp, n);
            // 预处理，按照位计算能否在一段session中完成
            for (int i = 1; i < m; i++) {
                int x = i, idx = 0;
                int time = 0;
                while (x > 0) {
                    if ((x & 1) == 1) {
                        time += tasks[idx];
                    }
                    x >>= 1;
                    idx++;
                }
                if (time <= sessionTime) {
                    dp[i] = 1;
                }
            }

            for (int i = 1; i < m; i++) {
                if (dp[i] == 1) {
                    continue;
                }
                for (int j = i; j > 0; j = (j - 1) & i) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i ^ j]);
                }
            }
            return dp[m - 1];
        }
    }
}
