import java.util.Arrays;

public class Leetcode1626 {

    public int bestTeamScore(int[] scores, int[] ages) {

        int n = scores.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int[][] nums = new int[n][2];
        int res = 0;
        for (int i = 0; i < n; i++) {
            nums[i][0] = scores[i];
            nums[i][1] = ages[i];
        }
        Arrays.sort(
                nums,
                (o1, o2) -> {
                    if (o1[0] != o2[0]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                });

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i][0];
            for (int j = 0; j < i; j++) {
                if (nums[i][1] >= nums[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i][0]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
