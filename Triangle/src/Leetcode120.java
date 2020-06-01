import java.util.List;

public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[] dp = triangle.get(n-1).toArray(new Integer[0]);
        for (int i=n-2; i>=0; --i) {
            for (int j=0; j<=i; ++j) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
