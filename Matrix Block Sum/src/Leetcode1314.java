public class Leetcode1314 {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                preSum[i + 1][j + 1] =
                        preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + mat[i][j];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int r1 = Math.max(0, i - K), c1 = Math.max(0, j - K);
                int r2 = Math.min(m, i + K + 1), c2 = Math.min(n, j + K + 1);
                res[i][j] = preSum[r2][c2] - preSum[r2][c1] - preSum[r1][c2] + preSum[r1][c1];
            }
        }

        return res;
    }
}
