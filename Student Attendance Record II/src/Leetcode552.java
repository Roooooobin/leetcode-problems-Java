public class Leetcode552 {

    // 第一次完整无误的推导出hard难度DP题！！！庆祝一下
    public int checkRecord(int n) {

        final int MOD = 1000000007;
        int[][][] dp = new int[n][3][2];
        // 第一维i：表示长度为i时各种情况下的记录数
        // 第二维0: P, 1: L, 2: A，表示长度为i，以该字符结尾时记录数
        // 第三维0：表示前面没有出现A的情况，1：表示前面有一个A的情况
        // 不能连续三个L所以需要删除LLL的情况: -dp[i-3][P][0], -dp[i-3][A][1], -dp[i-3][P][1];
        dp[0][0][0] = 1;
        dp[0][1][0] = 1;
        dp[0][2][1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][1][0]) % MOD;
            dp[i][1][0] = (dp[i - 1][0][0] + dp[i - 1][1][0]) % MOD;
            // 删除...PLLL的情况，P前没有A
            if (i == 2) {
                // 特别的dp[2][L][0]出现了LLL，也需要-1
                dp[i][1][0] -= 1;
            } else if (i > 2) {
                dp[i][1][0] = (dp[i][1][0] + MOD - dp[i - 3][0][0]) % MOD;
            }
            dp[i][0][1] = ((dp[i - 1][0][1] + dp[i - 1][1][1]) % MOD + dp[i - 1][2][1]) % MOD;
            dp[i][1][1] = ((dp[i - 1][0][1] + dp[i - 1][1][1]) % MOD + dp[i - 1][2][1]) % MOD;
            // 删除...PLLL，P前有A和...ALLL
            if (i > 2) {
                dp[i][1][1] = (dp[i][1][1] + MOD - (dp[i - 3][0][1] + dp[i - 3][2][1]) % MOD) % MOD;
            }
            dp[i][2][1] = (dp[i - 1][0][0] + dp[i - 1][1][0]) % MOD;
        }
        int res = (dp[n - 1][0][0] + dp[n - 1][1][0]) % MOD;
        for (int i = 0; i < 3; i++) {
            res = (res + dp[n - 1][i][1]) % MOD;
        }
        return res;
    }
}
