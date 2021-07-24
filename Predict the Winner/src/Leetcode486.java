public class Leetcode486 {

    public boolean PredictTheWinner(int[] nums) {

        int n = nums.length;
        // 当前选择的分数，减去，往后对手赢过自己的分数（对剩余数组递归）
        // dp[i][j]: 当前玩家在数组[i:j]中先手，所赢过对方的分数。
        int[][] dp = new int[n][n];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                int pickI = nums[i] - dp[i + 1][j];
                int pickJ = nums[j] - dp[i][j - 1];
                dp[i][j] = Math.max(pickI, pickJ);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}

/*
cr. https://leetcode-cn.com/problems/predict-the-winner/solution/ji-yi-hua-di-gui-dong-tai-gui-hua-java-by-liweiwei/
相对分数 说成 净胜分 ，语义会更强一些。

甲乙比赛，甲先手面对区间[i...j]时，dp[i][j]表示甲对乙的净胜分。

最终求的就是，甲先手面对区间[0...n-1]时，甲对乙的净胜分dp[0][n-1]是否>=0。

甲先手面对区间[i...j]时，

如果甲拿nums[i]，那么变成乙先手面对区间[i+1...j]，这段区间内乙对甲的净胜分为dp[i+1][j]；那么甲对乙的净胜分就应该是nums[i] - dp[i+1][j]。
如果甲拿nums[j]，同理可得甲对乙的净胜分为是nums[j] - dp[i][j-1]。
以上两种情况二者取大即可。
 */
