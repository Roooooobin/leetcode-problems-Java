public class Leetcode650 {

    public int minSteps(int n) {

        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            // if no factor, can only be formed by single A, thus 1 copy and n - 1 paste
            dp[i] = i;
            // find factors
            for (int factor = 2; factor * factor <= i; factor++) {
                if (i % factor == 0) {
                    // dp[factor] + 1 copy and (i / factor - 1) paste
                    dp[i] = Math.min(dp[i], dp[factor] + 1 + i / factor - 1);
                    dp[i] = Math.min(dp[i], dp[i / factor] + 1 + factor - 1);
                }
            }
        }
        return dp[n];
    }

    class Solution {
        public int minSteps(int n) {
            int res = 0;
            for (int i = 2; i * i <= n; ++i) {
                while (n % i == 0) {
                    n /= i;
                    res += i;
                }
            }
            if (n > 1) {
                res += n;
            }
            return res;
        }
    }
}
