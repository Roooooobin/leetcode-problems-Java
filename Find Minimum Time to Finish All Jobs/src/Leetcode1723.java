/*
https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/solution/gong-shui-san-xie-yi-ti-shuang-jie-jian-4epdd/
 */
public class Leetcode1723 {

    int min = 0x3f3f3f3f;
    // 优先分配空闲工人
    public int minimumTimeRequired(int[] jobs, int k) {

        dfs(jobs, 0, k, new int[k], 0, 0);
        return min;
    }

    public void dfs(int[] a, int idx, int k, int[] time, int used, int max) {

        if (max > min) {
            return;
        }
        if (idx == a.length) {
            min = max;
            return;
        }
        if (used < k) {
            time[used] = a[idx];
            dfs(a, idx + 1, k, time, used + 1, Math.max(time[used], max));
            time[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            time[i] += a[idx];
            dfs(a, idx + 1, k, time, used, Math.max(time[i], max));
            time[i] -= a[idx];
        }
    }
}
