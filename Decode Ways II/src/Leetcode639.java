public class Leetcode639 {

    /*
    inspired by https://leetcode-cn.com/problems/decode-ways-ii/solution/si-lu-qing-xi-jian-dan-yi-dong-by-acw_weian/
     */
    private static final int MOD = (int) 1e9 + 7;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();

        long[] dp = new long[n + 1];
        dp[0] = 1;
        // 前位占一个空字符
        char[] a = (" " + s).toCharArray();
        // 对于a[i]的三种情况，分别计算单独解码和前一位共同解码的个数
        for (int i = 1; i <= n; ++i) {

            if (a[i] == '*') {
                dp[i] = (dp[i - 1] * 9) % MOD;
                if (a[i - 1] == '1') {
                    dp[i] = (dp[i] + dp[i - 2] * 9) % MOD;
                } else if (a[i - 1] == '2') {
                    dp[i] = (dp[i] + 6 * dp[i - 2]) % MOD;
                } else if (a[i - 1] == '*') {
                    dp[i] = (dp[i] + 15 * dp[i - 2]) % MOD;
                }
            } else if (a[i] == '0') {
                if (a[i - 1] == '1' || a[i - 1] == '2') {
                    dp[i] = dp[i - 2];
                } else if (a[i - 1] == '*') {
                    dp[i] = dp[i - 2] * 2 % MOD;
                } else return 0;
            } else {
                dp[i] = dp[i - 1];
                if (a[i - 1] == '1') {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                } else if (a[i - 1] == '2' && a[i] - '0' >= 1 && a[i] - '0' <= 6) {
                    dp[i] = (dp[i] + dp[i - 2]) % MOD;
                } else if (a[i - 1] == '*') {
                    if (a[i] - '0' >= 7 && a[i] - '0' <= 9) {
                        dp[i] = (dp[i] + dp[i - 2]) % MOD;
                    } else {
                        dp[i] = (dp[i] + 2 * dp[i - 2]) % MOD;
                    }
                }
            }
        }
        return (int) (dp[n] % MOD);
    }
}
