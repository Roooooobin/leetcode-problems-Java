public class Leetcode926 {

    public int minFlipsMonoIncr(String s) {

        int n = s.length();
        // dp[i][j]表示在i位置，j（0或1）状态时最小翻转次数
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            dp1 = Math.min(dp0, dp1) + 1 - (s.charAt(i) - '0');
            dp0 = dp0 + s.charAt(i) - '0';
        }
        return Math.min(dp0, dp1);
    }
}

// AC
/*
   public int minFlipsMonoIncr(String s) {

       int n = s.length();
       // dp[i][j]表示在i位置，j（0或1）状态时最小翻转次数
       int[][] dp = new int[n + 1][2];
       for (int i = 0; i < n; i++) {
           if (s.charAt(i) == '0') {
               dp[i + 1][0] = dp[i][0];
               dp[i + 1][1] = Math.min(dp[i][0], dp[i][1]) + 1;
           } else {
               dp[i + 1][0] = dp[i][0] + 1;
               dp[i + 1][1] = Math.min(dp[i][0], dp[i][1]);
           }
       }
       return Math.min(dp[n][0], dp[n][1]);
   }
*/

// WA
/*
public int minFlipsMonoIncr(String s) {

        int n = s.length();
        char[] p = s.toCharArray();
        int res = Integer.MAX_VALUE;
        boolean change1to0 = false;
        int count;
        if (p[0] == '1') {
            // 不改变首1，直接把后面的0改为1
            count = 0;
            for (int i = 1; i < n; i++) {
                if (p[i] == '0') {
                    count++;
                }
            }
            res = Math.min(res, count);
            // 变首1为0
            change1to0 = true;
        }
        int i = 1;
        count = change1to0 ? 1 : 0;
        while (i < n && p[i] == '0') {
            i++;
        }
        int count0 = 0, count1 = 0;
        for (; i < n; i++) {
            if (p[i] == '1') {
                count1++;
            } else {
                count0++;
            }
        }
        res = Math.min(res, Math.min(count0, count1) + count);

        return res;
    }
 */
