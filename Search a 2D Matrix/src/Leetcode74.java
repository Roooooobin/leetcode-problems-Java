public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        if (m == 0) return false;
        int l = 0, r = n * m - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / m;
            int col = mid % m;
            if (matrix[row][col] > target) {
                r = mid - 1;
            }
            else if(matrix[row][col] < target) {
                l = mid + 1;
            }
            else return true;
        }
        return false;
    }
}
