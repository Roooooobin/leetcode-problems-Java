public class Jianzhi12 {

    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {

        int m = board.length, n = board[0].length;
        char first = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == first) {
                    boolean[] seen = new boolean[m * n];
                    seen[i * n + j] = true;
                    if (dfs(board, i, j, word, 0, seen)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] a, int i, int j, String word, int idx, boolean[] seen) {

        if (word.charAt(idx) == a[i][j]) {
            if (idx == word.length() - 1) {
                return true;
            }
        } else {
            return false;
        }
        for (int[] direction : directions) {
            int ni = direction[0] + i, nj = direction[1] + j;
            int v = ni * a[0].length + nj;
            if (ni >= 0 && ni < a.length && nj >= 0 && nj < a[0].length && !seen[v]) {
                seen[v] = true;
                if (dfs(a, ni, nj, word, idx + 1, seen)) {
                    return true;
                }
                seen[v] = false;
            }
        }
        return false;
    }
}
