import java.util.HashSet;
import java.util.Set;

public class Leetcode688 {

    private final int[][] knightDirections = {
        {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
    };

    public double knightProbability(int n, int K, int row, int column) {

        if (K == 0) {
            return 1.0;
        }
        double possibility = 0.125;
        double[][][] dp = new double[n][n][K + 1];
        dp[row][column][0] = 1.0;
        Set<Integer> set = new HashSet<>();
        set.add(makeKey(row, column, n));
        for (int k = 0; k < K; k++) {
            Set<Integer> nxt = new HashSet<>();
            for (Integer cor : set) {
                int x = cor / n, y = cor % n;
                for (int[] direction : knightDirections) {
                    int nx = x + direction[0], ny = y + direction[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        nxt.add(makeKey(nx, ny, n));
                        dp[nx][ny][k + 1] += possibility * dp[x][y][k];
                    }
                }
            }
            set = nxt;
        }
        double res = 0.0;
        for (Integer cor : set) {
            int x = cor / n, y = cor % n;
            res += dp[x][y][K];
        }
        return res;
    }

    public int makeKey(int row, int col, int n) {

        return row * n + col;
    }

    public static void main(String[] args) {

        Leetcode688 ins = new Leetcode688();
        ins.knightProbability(3, 2, 0, 0);
    }
}
