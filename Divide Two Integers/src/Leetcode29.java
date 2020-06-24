public class Leetcode29 {
    // helped by solution
    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) return Integer.MAX_VALUE;
        int a = Math.abs(dividend), b = Math.abs(divisor);
        int ans = 0;
        for (int i=31; i>=0; --i) {
            if ((a >>> i) - b >= 0) {
                ans += 1 << i;
                a -= (b << i);
            }
        }
        return (dividend > 0) == (divisor > 0) ? ans : -ans;
    }
}
