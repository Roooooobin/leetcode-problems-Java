public class Leetcode1922 {

    final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long choiceAtEven = 5, choiceAtOdd = 4;
        return (int) (quickPow(choiceAtEven, n - n / 2) * quickPow(choiceAtOdd, n / 2) % MOD);
    }

    public long quickPow(long x, long n) {

        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
            n >>= 1;
        }
        return res % MOD;
    }
}
