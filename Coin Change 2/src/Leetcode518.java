import java.util.Arrays;

public class Leetcode518 {
    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i=coin; i<=amount; ++i) {
                dp[i] += dp[i-coin];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }
}
