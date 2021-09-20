public class Leetcode1275 {

    final int AColor = 2;
    final int BColor = 7;

    public String tictactoe(int[][] moves) {

        int[][] grid = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            int color = AColor;
            if ((i & 1) == 1) {
                color = BColor;
            }
            grid[moves[i][0]][moves[i][1]] = color;
            String check = isFinished(grid);
            if (!check.equals("")) {
                return check;
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    public String isFinished(int[][] grid) {
        for (int i = 0; i < 3; i++) {
            int rowSum = 0;
            for (int j = 0; j < 3; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum == AColor * 3) {
                return "A";
            } else if (rowSum == BColor * 3) {
                return "B";
            }
        }
        for (int i = 0; i < 3; i++) {
            int colSum = 0;
            for (int j = 0; j < 3; j++) {
                colSum += grid[j][i];
            }
            if (colSum == AColor * 3) {
                return "A";
            } else if (colSum == BColor * 3) {
                return "B";
            }
        }
        int diagonalSum = grid[0][0] + grid[1][1] + grid[2][2];
        if (diagonalSum == AColor * 3) {
            return "A";
        } else if (diagonalSum == BColor * 3) {
            return "B";
        }
        diagonalSum = grid[2][0] + grid[1][1] + grid[0][2];
        if (diagonalSum == AColor * 3) {
            return "A";
        } else if (diagonalSum == BColor * 3) {
            return "B";
        }
        return "";
    }
}
