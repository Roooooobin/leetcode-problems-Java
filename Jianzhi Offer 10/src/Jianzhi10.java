public class Jianzhi10 {

    public int fib(int n) {

        int a = 0, b = 1, c;
        final int MOD = 1000000007;
        for (int i = 1; i < n; i++) {
            c = b;
            b = (a + b) % MOD;
            a = c;
        }
        return n == 0 ? 0 : b;
    }
}
