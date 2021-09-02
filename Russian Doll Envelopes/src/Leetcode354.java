import java.util.Arrays;

public class Leetcode354 {

    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        Arrays.sort(
                envelopes,
                (o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                });
        int[] dp = new int[n + 1];
        int len = 1;
        dp[0] = envelopes[0][1];
        for (int i = 1; i < n; i++) {

            int cur = envelopes[i][1];
            if (cur > dp[len - 1]) {
                dp[len++] = cur;
            } else {
                int l = lowerBound(dp, 0, len - 1, cur);
                if (l < 0) {
                    l = -l - 1;
                }
                dp[l] = cur;
            }
        }
        return len;
    }

    public int lowerBound(int[] a, int l, int r, int tar) {

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (a[mid] < tar) {
                l = mid + 1;
            } else if (a[mid] > tar) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -(l + 1);
    }

    public static void main(String[] args) {

        int[][] a = new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Leetcode354 ins = new Leetcode354();
        System.out.println(ins.maxEnvelopes(a));
    }
}
