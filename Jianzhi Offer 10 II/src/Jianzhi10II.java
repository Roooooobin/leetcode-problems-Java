public class Jianzhi10II {

    public int numWays(int n) {

        int a = 1, b = 2, c;
        final int MOD = 1000000007;
        for (int i = 1; i < n; i++) {
            c = b;
            b = (a + b) % MOD;
            a = c;
        }
        return a;
    }
}
