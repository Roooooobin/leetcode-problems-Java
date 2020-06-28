import java.util.ArrayList;
import java.util.List;

public class Leetcode52 {
    private int count = 0;

    public void dfs(int n, int row, char[][] board, boolean[] col, boolean[] diaL, boolean[] diaR) {
        // 顺利摆到了最后一排
        if (row == n) {
            count++;
        }
        // 依次尝试每一列
        for (int j=0; j<n; ++j) {
            // 如果这一列，或者左对角线/右对角线已经放了皇后了则无法放置
            if (col[j] || diaL[row + j] || diaR[row + n - j - 1]) {
                continue;
            }
            // 尝试摆放
            col[j] = true;
            diaL[row + j] = true;
            diaR[row + n - j - 1] = true;
            board[row][j] = 'Q';
            dfs(n, row+1, board, col, diaL, diaR);
            // 回溯
            col[j] = false;
            diaL[row + j] = false;
            diaR[row + n - j - 1] = false;
            board[row][j] = '.';
        }
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i=0; i<n; ++i) {
            for (int j=0; j<n; ++j) {
                board[i][j] = '.';
            }
        }
        dfs(n, 0, board, new boolean[n], new boolean[2*n-1], new boolean[2*n-1]);
        return count;
    }
}
