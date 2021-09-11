public class Leetcode1601 {

    public int maximumRequests(int n, int[][] requests) {

        int m = 1 << requests.length;
        int res = 0;
        for (int i = 1; i < m; i++) {
            int[] state = new int[n];
            int idx = 0;
            int count = 0;
            int x = i;
            while (x > 0) {
                if ((x & 1) == 1) {
                    state[requests[idx][0]]++;
                    state[requests[idx][1]]--;
                    count++;
                }
                x >>= 1;
                idx++;
            }
            int j = 0;
            for (; j < n; j++) {
                if (state[j] != 0) {
                    break;
                }
            }
            if (j == n) {
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode1601 ins = new Leetcode1601();
        ins.maximumRequests(5, new int[][] {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}});
    }
}
