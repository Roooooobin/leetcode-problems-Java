public class Jianzhi60 {
    public double[] dicesProbability(int n) {

        final double PROBABILITY = 1.0 / 6;
        double[] res = new double[5 * n + 1];
        double[][] dp = new double[6 * n + 1][n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[i][1] = PROBABILITY;
        }
        for (int i = 2; i <= n; i++) {
            for (int dice = i; dice <= 6 * i; dice++) {
                for (int j = 1; j <= 6; j++) {
                    if (dice - j < i - 1 || dice - j > (i - 1) * 6) {
                        continue;
                    }
                    dp[dice][i] += (PROBABILITY) * dp[dice - j][i - 1];
                }
            }
        }
        int idx = 0;
        for (int dice = n; dice <= 6 * n; dice++) {
            res[idx++] = dp[dice][n];
        }

        return res;
    }
}
