public class Interview46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; ++i) {
            int oneBitValue = Integer.parseInt(s.substring(i-1, i));
            int twoBitValue = Integer.parseInt(s.substring(i-2, i));
            if (oneBitValue >= 0 && oneBitValue <= 9) {
                dp[i] += dp[i-1];
            }
            if (twoBitValue >= 10 && twoBitValue <= 25) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
