import java.util.Arrays;

public class Leetcode279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=0; i*i<=n; ++i) {
            dp[i * i] = 1;
        }
        for(int i=1; i<=n; ++i) {  //选定第一个数为 i
            for(int j=1; i+j*j<=n; ++j) {  //选定另一个数为 j*j
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //从小到大查找
            }
        }
        return dp[n];
    }
}
