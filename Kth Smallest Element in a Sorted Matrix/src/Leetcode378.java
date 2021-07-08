public class Leetcode378 {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int lower = matrix[0][0], upper = matrix[n - 1][n - 1];
        while (lower < upper) {
            int mid = lower + ((upper - lower) >> 1);
            if (check(matrix, n, k, mid)) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }

        return lower;
    }

    public boolean check(int[][] matrix, int n, int k, int mid) {

        int i = 0, j = n - 1;
        int num = 0;
        while (i <= n - 1 && j >= 0) {
            if (matrix[i][j] <= mid) {
                ++i;
                num += j + 1;
            } else {
                --j;
            }
        }
        return num >= k;
    }
}
