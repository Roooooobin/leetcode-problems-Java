public class Leetcode73 {

    public void setZeroes(int[][] matrix) {

        boolean row0Flag = false, col0Flag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                col0Flag = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                row0Flag = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = matrix.length - 1; i >= 1; i--) {
            for (int j = matrix[i].length - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (col0Flag) {
                matrix[i][0] = 0;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (row0Flag) {
                matrix[0][j] = 0;
            }
        }
    }
}
