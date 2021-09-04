public class LCS03 {

    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int count = 0;
    boolean flag = true;

    public int largestArea(String[] grid) {

        int m = grid.length, n = grid[0].length();
        char[][] arr = new char[m][n];
        // 不能与走廊直接相连，如果在dfs时遇到了走廊，此次dfs作废
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = grid[i].charAt(j);
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != '0' && arr[i][j] != '6') {
                    count = 0;
                    flag = true;
                    dfs(arr, i, j, arr[i][j]);
                    if (flag) {
                        res = Math.max(res, count);
                    }
                }
            }
        }
        return res;
    }

    public void dfs(char[][] a, int i, int j, char c) {

        int m = a.length, n = a[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] == '0') {
            flag = false;
            return;
        }
        if (a[i][j] != c) {
            return;
        }
        count++;
        a[i][j] = '6';

        for (int[] direction : directions) {
            dfs(a, i + direction[0], j + direction[1], c);
        }
    }
}
