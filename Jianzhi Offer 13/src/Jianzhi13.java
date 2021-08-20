public class Jianzhi13 {

    int res = 0;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int movingCount(int m, int n, int k) {

        boolean[] seen = new boolean[m * n];
        dfs(m, n, k, 0, 0, seen);
        return res;
    }

    public void dfs(int m, int n, int k, int i, int j, boolean[] seen) {

        if (countDigitSum(i, j) > k) {
            return;
        }
        seen[i * n + j] = true;
        res++;
        for (int[] direction : directions) {
            int ni = direction[0] + i, nj = direction[1] + j;
            int v = ni * n + nj;
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[v]) {
                dfs(m, n, k, ni, nj, seen);
            }
        }
    }

    public int countDigitSum(int i, int j) {

        int sumI = 0, sumJ = 0;
        while (i > 0) {
            sumI += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sumJ += j % 10;
            j /= 10;
        }
        return sumI + sumJ;
    }
}
