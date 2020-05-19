public class Leetcode70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int a = 1, b = 2;
        for (int i=0; i<n-2; ++i) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
