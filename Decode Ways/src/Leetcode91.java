public class Leetcode91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; ++i) {
            int oneBitValue = Integer.parseInt(s.substring(i-1, i));
            int twoBitValue = Integer.parseInt(s.substring(i-2, i));
            if (oneBitValue >= 1 && oneBitValue <= 9) {
                dp[i] += dp[i-1];
            }
            if (twoBitValue >= 10 && twoBitValue <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
