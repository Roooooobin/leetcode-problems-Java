import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1380 {

    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {

            int m = matrix.length;
            int n = matrix[0].length;
            int[] row = new int[m];
            Arrays.fill(row, 1000000);
            int[] col = new int[n];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    row[i] = Math.min(row[i], matrix[i][j]);
                    col[j] = Math.max(col[j], matrix[i][j]);
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == row[i] && matrix[i][j] == col[j]) {
                        res.add(matrix[i][j]);
                    }
                }
            }
            return res;
        }
    }
}
