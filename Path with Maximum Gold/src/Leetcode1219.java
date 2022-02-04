public class Leetcode1219 {

    class Solution {

        int max = 0;
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int getMaximumGold(int[][] grid) {

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != 0) {
                        dfs(i, j, grid, 0);
                    }
                }
            }
            return max;
        }

        void dfs(int i, int j, int[][] a, int v) {

            v += a[i][j];
            max = Math.max(max, v);

            int t = a[i][j];
            a[i][j] = 0;
            for (int[] direction : directions) {
                int ni = i + direction[0], nj = j + direction[1];
                if (ni < 0 || ni >= a.length || nj < 0 || nj >= a[i].length || a[ni][nj] == 0) {
                    continue;
                }
                dfs(ni, nj, a, v);
            }
            a[i][j] = t;
        }
    }
}
