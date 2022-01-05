public class Leetcode1504 {

    public int numSubmat(int[][] mat) {

        int m = mat.length, n = mat[0].length;
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            nums[i][0] = mat[i][0];
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 1) {
                    nums[i][j] = nums[i][j - 1] + 1;
                }
            }
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                res += nums[i][j];
                int min = nums[i][j];
                for (int k = i - 1; k >= 0; k--) {
                    if (nums[k][j] == 0) {
                        break;
                    }
                    min = Math.min(min, nums[k][j]);
                    res += min;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        //        int[][] mat = new int[][] {{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
        int[][] mat =
                new int[][] {{1, 1, 1, 1, 0}, {1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 1, 0, 0, 0}};
        Leetcode1504 ins = new Leetcode1504();
        System.out.println(ins.numSubmat(mat));
    }
}
