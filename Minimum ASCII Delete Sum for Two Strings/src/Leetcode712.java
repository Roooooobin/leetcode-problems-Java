public class Leetcode712 {

    // find the longest common sequence
    public int minimumDeleteSum(String s1, String s2) {

        int m = s1.length(), n = s2.length();
        int total = 0;
        for (int i = 0; i < m; i++) {
            total += s1.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            total += s2.charAt(i);
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++) {
                if (c1 == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + c1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return total - 2 * dp[m][n];
    }
}
