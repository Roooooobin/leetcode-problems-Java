import java.util.Arrays;

public class Leetcode542 {

    public int[][] updateMatrix(int[][] mat) {

        int[][] dp = new int[mat.length][mat[0].length];
        //        for (int i = 0; i < mat.length; i++) {
        //            for (int j = 0; j < mat[i].length; j++) {
        //                dp[i][j] = Integer.MAX_VALUE / 2;
        //            }
        //        }
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
            }
        }

        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[i].length - 1; j >= 0; j--) {
                if (i < mat.length - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < mat[i].length - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
