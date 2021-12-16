public class Leetcode794 {

    public boolean validTicTacToe(String[] board) {

        int oCount = 0, xCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') {
                    oCount++;
                }
                if (board[i].charAt(j) == 'X') {
                    xCount++;
                }
            }
        }
        return !(oCount != xCount && oCount != xCount - 1 || oCount != xCount && win(board, 'O'))
                || oCount != xCount - 1 && win(board, 'X');
    }

    public boolean win(String[] board, char c) {

        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c
                    || board[0].charAt(i) == c
                            && board[1].charAt(i) == c
                            && board[2].charAt(i) == c) {
                return true;
            }
        }
        return board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c
                || board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c;
    }
}
