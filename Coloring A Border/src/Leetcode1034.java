public class Leetcode1034 {

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int nonColor = 0x3f3f3f3f;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        dfs(grid, row, col);
        // < 0 recover(0 is also applicable), nonColor -> color
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == nonColor) {
                    grid[i][j] = color;
                } else if (grid[i][j] < 0) {
                    grid[i][j] *= -1;
                }
            }
        }
        return grid;
    }

    public void dfs(int[][] a, int x, int y) {

        if (!inGrid(a, x, y)) {
            return;
        }
        int curColor = a[x][y];
        if (isAtBorder(a, x, y)) {
            // grid border, color
            a[x][y] = nonColor;
            for (int[] direction : directions) {
                int nx = x + direction[0], ny = y + direction[1];
                if (inGrid(a, nx, ny) && a[nx][ny] == curColor) {
                    dfs(a, nx, ny);
                }
            }
        } else {
            boolean flag = true;
            for (int[] direction : directions) {
                int nx = x + direction[0], ny = y + direction[1];
                if (a[nx][ny] != curColor && a[nx][ny] != nonColor && a[nx][ny] > 0) {
                    flag = false;
                    break;
                }
            }
            // as a border, needs to be colored as color
            if (!flag) {
                a[x][y] = nonColor;
            } else {
                // marked as visited
                a[x][y] = -curColor;
            }
            for (int[] direction : directions) {
                int nx = x + direction[0], ny = y + direction[1];
                if (inGrid(a, nx, ny) && a[nx][ny] == curColor) {
                    dfs(a, nx, ny);
                }
            }
        }
    }

    // if not at the boarder
    public boolean isAtBorder(int[][] a, int x, int y) {

        int m = a.length, n = a[0].length;
        return x == m - 1 || x == 0 || y == n - 1 || y == 0;
    }

    public boolean inGrid(int[][] a, int x, int y) {

        return x >= 0 && x < a.length && y >= 0 && y < a[0].length;
    }
}
