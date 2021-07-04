import java.util.TreeSet;

public class Leetcode363 {

    /*
    inspired by https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/solution/ju-xing-qu-yu-bu-chao-guo-k-de-zui-da-sh-70q2/
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {

        int ans = Integer.MIN_VALUE;
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        // i上边界，j下边界
        for (int i = 0; i < m; ++i) {
            int[] sumPrefix = new int[n];
            for (int j = i; j < m; ++j) {

                for (int c = 0; c < n; ++c) {
                    sumPrefix[c] += matrix[j][c];
                }
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int sum = 0;
                for (int x : sumPrefix) {
                    sum += x;
                    // 得到最小的 >=sum-k 的值
                    Integer ceil = sumSet.ceiling(sum - k);
                    if (ceil != null) {
                        ans = Math.max(ans, sum - ceil);
                    }
                    sumSet.add(sum);
                }
            }
        }

        return ans;
    }
}
