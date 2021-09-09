import java.util.Arrays;

public class Leetcode764 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {

        int[][] a = new int[n][n];
        for (int[] row : a) {
            Arrays.fill(row, 1);
        }
        for (int[] mine : mines) {
            a[mine[0]][mine[1]] = 0;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    continue;
                }
                // 从当前位置出发，就算最长延伸满足了条件还是比当前最大值小，则剪枝
                int curMax = Math.min(i + 1, j + 1);
                curMax = Math.min(curMax, n - i);
                curMax = Math.min(curMax, n - j);
                if (curMax <= res) {
                    continue;
                }
                int up = 1, right = 1, down = 1, left = 1;
                while (i - up >= 0 && a[i - up][j] == 1) {
                    up++;
                }
                while (j + right < n && a[i][j + right] == 1) {
                    right++;
                }
                while (i + down < n && a[i + down][j] == 1) {
                    down++;
                }
                while (j - left >= 0 && a[i][j - left] == 1) {
                    left++;
                }
                curMax = up;
                curMax = Math.min(curMax, right);
                curMax = Math.min(curMax, down);
                curMax = Math.min(curMax, left);
                res = Math.max(res, curMax);
            }
        }
        return res;
    }
}
