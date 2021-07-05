public class Leetcode1220 {

    private static final int A = 0;
    private static final int E = 1;
    private static final int I = 2;
    private static final int O = 3;
    private static final int U = 4;
    private static final int col = 5;
    private static final int MOD = (int) (1e9 + 7);

    public static int countVowelPermutation(int n) {

        long[][] dp = new long[n][5];
        for (int j = 0; j < col; ++j) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; ++i) {
            dp[i][A] = (dp[i - 1][E] + +dp[i - 1][I] + dp[i - 1][U]) % MOD;
            dp[i][E] = (dp[i - 1][A] + dp[i - 1][I]) % MOD;
            dp[i][I] = (dp[i - 1][E] + dp[i - 1][O]) % MOD;
            dp[i][O] = (dp[i - 1][I]) % MOD;
            dp[i][U] = (dp[i - 1][I] + dp[i - 1][O]) % MOD;
        }

        long ans = 0;
        for (int i = 0; i < col; ++i) {
            ans = (ans + dp[n - 1][i]) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(countVowelPermutation(2));
    }
}
