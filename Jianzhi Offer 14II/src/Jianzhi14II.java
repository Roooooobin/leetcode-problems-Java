public class Jianzhi14II {

    public int cuttingRope(int n) {

        final int MOD = 1000000007;
        if (n <= 3) {
            return n - 1;
        }
        long product = 1;
        int a = n / 3, b = n % 3;
        while (a > 1) {
            product = product * (long) 3 % MOD;
            a--;
        }
        if (b == 0) {
            return (int) (product * (long) 3 % MOD);
        } else if (b == 1) {
            return (int) (product * (long) 4 % MOD);
        } else {
            return (int) (product * (long) 6 % MOD);
        }
    }
}
