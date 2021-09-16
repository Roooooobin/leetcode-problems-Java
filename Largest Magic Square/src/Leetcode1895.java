public class Leetcode1895 {

    public static void main(String[] args) {

        Leetcode1895 ins = new Leetcode1895();
        int[][] grid =
                new int[][] {{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}};
        ins.largestMagicSquare(grid);
    }

    public int largestMagicSquare(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[][] rowPrefixSum = new int[m][n + 1];
        int[][] colPrefixSum = new int[n][m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                rowPrefixSum[i][j] = rowPrefixSum[i][j - 1] + grid[i][j - 1];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= m; i++) {
                colPrefixSum[j][i] = colPrefixSum[j][i - 1] + grid[i - 1][j];
            }
        }
        for (int k = Math.min(m, n) - 1; k >= 1; k--) {
            for (int i = 0; i < m - k; i++) {
                for (int j = 0; j < n - k; j++) {
                    int sum = rowPrefixSum[i][j + k + 1] - rowPrefixSum[i][j];
                    boolean flag = true;
                    // every row
                    for (int p = i + 1; p <= i + k; p++) {
                        if (rowPrefixSum[p][j + k + 1] - rowPrefixSum[p][j] != sum) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        continue;
                    }
                    // every column
                    for (int p = j; p <= j + k; p++) {
                        if (colPrefixSum[p][i + k + 1] - colPrefixSum[p][i] != sum) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        continue;
                    }
                    // two diagonals
                    int sumD1 = 0, sumD2 = 0;
                    for (int p = 0; p <= k; p++) {
                        sumD1 += grid[i + p][j + p];
                        sumD2 += grid[i + p][j + k - p];
                    }
                    if (sumD1 == sum && sumD2 == sum) {
                        return k + 1;
                    }
                }
            }
        }
        return 1;
    }
}
