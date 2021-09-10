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
}
