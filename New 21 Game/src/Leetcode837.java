public class Leetcode837 {
    // TLE
    public static double new21Game(int N, int K, int W) {
        double p = 1.0 / W;
        double[] probabilities = new double[W+K+1];
        probabilities[0] = 1;
        for (int i=0; i<K; ++i) {
            for (int j=1; j<=W; ++j) {
                probabilities[i+j] += probabilities[i] * p;
            }
        }
        double ans = 0.0;
        for (int i=K; i<=N; ++i) {
            ans += probabilities[i];
        }
        return ans;
    }

    class Solution {
        // dp[x] 表示从得分为 x 的情况开始游戏并且获胜的概率
        public double new21Game(int N, int K, int W) {
            if (K == 0) {
                return 1.0;
            }
            double[] dp = new double[K + W + 1];
            for (int i=K; i<=N && i<K+W; ++i) {
                dp[i] = 1.0;
            }
            dp[K-1] = 1.0 * Math.min(N-K+1, W) / W;
            for (int i=K-2; i>=0; --i) {
                dp[i] = dp[i+1] - (dp[i+W+1] - dp[i+1]) / W;
            }
            return dp[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(new21Game(21, 17, 10));
    }
}
