import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        for (int i=1; i<=n; ++i) {
            for (int j=0; j<i; ++j) {
                if ((j == 0 || dp[j]) && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
