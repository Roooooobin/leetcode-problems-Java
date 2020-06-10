public class Leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) --j;
            else ++i;
        }
        return false;
    }
}
