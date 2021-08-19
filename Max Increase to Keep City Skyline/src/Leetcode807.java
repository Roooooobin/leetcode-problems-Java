public class Leetcode807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int res = 0;
        int m = grid.length, n = grid[0].length;
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += (Math.min(rowMax[i], colMax[j]) - grid[i][j]);
            }
        }
        return res;
    }
}
