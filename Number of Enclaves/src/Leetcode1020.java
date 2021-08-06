public class Leetcode1020 {

    class Solution {

        private int M, N;
        private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int numEnclaves(int[][] grid) {
            M = grid.length;
            N = grid[0].length;
            for (int i = 0; i < M; ++i) {
                if (grid[i][0] == 1) {
                    dfs(grid, i, 0);
                }
                if (grid[i][N - 1] == 1) {
                    dfs(grid, i, N - 1);
                }
            }
            for (int i = 0; i < N; ++i) {
                if (grid[0][i] == 1) {
                    dfs(grid, 0, i);
                }
                if (grid[M - 1][i] == 1) {
                    dfs(grid, M - 1, i);
                }
            }
            //            for (int i = 0; i < M; i++) {
            //                System.out.println(Arrays.toString(grid[i]));
            //            }

            int res = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 1) {
                        ++res;
                    }
                }
            }
            return res;
        }

        public void dfs(int[][] grid, int x, int y) {

            grid[x][y] = 0;
            for (int[] direction : directions) {
                int nx = x + direction[0], ny = y + direction[1];
                if (nx <= 0 || nx >= M || ny <= 0 || ny >= N || grid[nx][ny] != 1) {
                    continue;
                }
                dfs(grid, nx, ny);
            }
        }
    }
}

/*

[
[0,0,0,1,1,1,0,1,0,0],
[1,1,0,0,0,1,0,1,1,1],
[0,0,0,1,1,1,0,1,0,0],
[0,1,1,0,0,0,1,0,1,0],
[0,1,1,1,1,1,0,0,1,0],
[0,0,1,0,1,1,1,1,0,1],
[0,1,1,0,0,0,1,1,1,1],
[0,0,1,0,0,1,0,1,0,1],
[0,0,1,0,1,1,0,0,0,0],
[0,0,0,0,1,1,0,0,0,0]]
 */
