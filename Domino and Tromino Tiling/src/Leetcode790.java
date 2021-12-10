public class Leetcode790 {

    public int numTilings(int n) {

        if (n <= 2) {
            return n;
        }
        final int MOD = 1_000_000_007;
        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];
        dp0[1] = 1;
        dp0[2] = 2;
        dp1[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp0[i] = (dp0[i - 1] + dp1[i - 2] + dp1[i - 1]) % MOD;
            dp1[i] = (dp0[i - 2] * 2 + dp1[i - 1]) % MOD;
        }
        return (int) (dp0[n] % MOD);
    }
}
