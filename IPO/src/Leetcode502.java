import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int res = 0;
        int n = profits.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < profits.length; i++) {
            a[i][0] = profits[i];
            a[i][1] = capital[i];
        }
        // sort by capital asc, profit desc
        Arrays.sort(
                a,
                (o1, o2) -> {
                    if (o1[1] != o2[1]) {
                        return o1[1] - o2[1];
                    }
                    return o2[0] - o1[0];
                });

        if (w < a[0][1]) {
            return w;
        }
        // get a new project and able to reach more projects,
        // every time choose the one with the most capital
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int pre = 0;
        for (int i = 0; i < k; i++) {
            int idx = lowerBound(a, w);
            for (int j = pre; j <= idx; j++) {
                pq.offer(a[j][0]);
            }
            if (pq.isEmpty()) {
                return w;
            }
            w += pq.poll();
            pre = idx + 1;
        }

        return w;
    }

    public int lowerBound(int[][] a, int tar) {

        int l = 0, r = a.length - 1;
        if (tar >= a[r][1]) {
            return r;
        }
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid][1] < tar) {
                l = mid + 1;
            } else if (a[mid][1] > tar) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return l - 1;
    }
}
