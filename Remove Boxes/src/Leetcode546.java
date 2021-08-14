public class Leetcode546 {

    // dp[l][r][k]表示移除区间[l, r]的元素al, ... ar加上该区间右边等于ar的k个元素组成的序列最大元素
    class Solution {
        int[][][] dp;

        public int removeBoxes(int[] boxes) {
            int n = boxes.length;
            dp = new int[n][n][n];
            return calcPoints(boxes, 0, n - 1, 0);
        }

        public int calcPoints(int[] a, int l, int r, int k) {
            if (l > r) {
                return 0;
            }
            if (dp[l][r][k] == 0) {
                dp[l][r][k] = calcPoints(a, l, r - 1, 0) + (k + 1) * (k + 1);
                for (int i = l; i < r; i++) {
                    if (a[i] == a[r]) {
                        dp[l][r][k] =
                                Math.max(
                                        dp[l][r][k],
                                        calcPoints(a, l, i, k + 1)
                                                + calcPoints(a, i + 1, r - 1, 0));
                    }
                }
            }
            return dp[l][r][k];
        }
    }

    // https://leetcode-cn.com/problems/remove-boxes/solution/yi-chu-he-zi-by-leetcode-solution/
}
