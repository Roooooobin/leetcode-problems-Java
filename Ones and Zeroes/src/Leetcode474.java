public class Leetcode474 {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        // 记录0和1的个数
        int len = strs.length;
        int[][] records = new int[len][2];
        for (int i = 0; i < strs.length; i++) {
            int zeros = 0, ones = 0;
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    ++zeros;
                } else {
                    ++ones;
                }
            }
            records[i][0] = zeros;
            records[i][1] = ones;
        }

        for (int i = 0; i < len; i++) {
            int zeros = records[i][0], ones = records[i][1];
            for (int j = m; j >= zeros; --j) {
                for (int k = n; k >= ones; --k) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
