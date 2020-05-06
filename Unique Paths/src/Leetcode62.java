public class Leetcode62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[103][103];
        dp[0][0] = 1;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(i > 0){
                    dp[i][j] += dp[i-1][j];
                }
                if(j > 0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
