public class Leetcode221 {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if(n == 0) return 0;
        int m = matrix[0].length;
        if(m == 0) return 0;
        int[][] dp = new int[n+1][m+1];
        int ans = -1;
        for(int i=1; i<=n; ++i){
            for(int j=1; j<=m; ++j){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }
}
