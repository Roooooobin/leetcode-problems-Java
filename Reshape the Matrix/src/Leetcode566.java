public class Leetcode566 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        if (m == 0) {
            return mat;
        }
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int row = 0;
        int col = 0;
        int idx = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (idx != 0 && idx % c == 0) {
                    row++;
                    col = 0;
                }
                res[row][col] = mat[i][j];
                ++idx;
                ++col;
            }
        }
        /*
        int[][] res = new int[r][c];
        for (int x = 0; x < m * n; ++x) {
            res[x / c][x % c] = mat[x / n][x % n];
        }
        return res;
             */

        return res;
    }
}
