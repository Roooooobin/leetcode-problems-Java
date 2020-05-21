public class Leetcode79 {
    public boolean dfs(char[][] board, String word, int i, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(i)) return false;
        if (i == word.length()-1) return true;
        board[r][c] ^= -1;
        boolean flag = dfs(board, word, i+1, r+1, c) || dfs(board, word, i+1, r-1, c) ||
                       dfs(board, word, i+1, r, c-1) || dfs(board, word, i+1, r, c+1);
        board[r][c] ^= -1;
        return flag;
    }

    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; ++i) {
            for (int j=0; j<board[0].length; ++j) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

}
