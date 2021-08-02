import java.util.Arrays;

public class Leetcode743 {

    private static final int MAXVALUE = Integer.MAX_VALUE / 2;

    public int networkDelayTime(int[][] times, int n, int k) {

        // 边图
        int[][] edges = new int[n + 1][n + 1];
        for (int[] edge : edges) {
            Arrays.fill(edge, MAXVALUE);
        }
        boolean[] visited = new boolean[n + 1];
        visited[k] = true;
        // dis[i]记录从源点到点i的最短路
        int[] dis = new int[n + 1];
        Arrays.fill(dis, MAXVALUE);
        for (int[] time : times) {
            edges[time[0]][time[1]] = time[2];
            if (time[0] == k) {
                dis[time[1]] = time[2];
            }
        }
        dis[k] = 0;
        dis[0] = 0;

        for (int idx = 1; idx < n; ++idx) {
            // 找到离源点最近且未访问过的点
            int minDis = MAXVALUE;
            int minIdx = 0;
            for (int i = 1; i <= n; ++i) {
                if (dis[i] < minDis && !visited[i]) {
                    minIdx = i;
                    minDis = dis[i];
                }
            }
            if (minDis == MAXVALUE) {
                return -1;
            }
            // 记录该点为已访问过
            visited[minIdx] = true;
            // 松弛
            for (int i = 1; i <= n; i++) {
                if (edges[minIdx][i] != MAXVALUE && dis[i] > dis[minIdx] + edges[minIdx][i]) {
                    dis[i] = dis[minIdx] + edges[minIdx][i];
                }
            }
        }
        int res = -1;
        for (int x : dis) {
            res = Math.max(res, x);
        }
        return res == MAXVALUE ? -1 : res;
    }
}
