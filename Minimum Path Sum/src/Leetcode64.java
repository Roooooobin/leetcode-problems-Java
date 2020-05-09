public class Leetcode64 {
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        if(m == 0) return 0;
        int[] dp = new int[m];
        dp[0] = grid[0][0];
        for(int j=1; j<m; ++j){
            dp[j] = dp[j-1] + grid[0][j];
        }
        for(int i=1; i<n; ++i) {
            dp[0] += grid[i][0];
            for(int j=1; j<m; ++j) {
                dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
            }
        }
        return dp[m-1];
    }

//    public static int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        for(int i=1; i<n; i++){
//            grid[0][i] += grid[0][i-1];
//        }
//        for(int i=1; i<m; i++) {
//            grid[i][0] += grid[i-1][0];
//            for(int j=1; j<n; j++) {
//                grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
//            }
//        }
//        return grid[m-1][n-1];
//    }

    public static void main(String[] args) {
        int[][] grid2 = {{1, 2}, {1, 1}};
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
