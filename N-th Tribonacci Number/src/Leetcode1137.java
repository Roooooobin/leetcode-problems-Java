public class Leetcode1137 {

    public int tribonacci(int n) {

        int[] arr = new int[] {0, 1, 1};
        if (n < 4) {
            return arr[n];
        }
        int x0 = 0, x1 = 1, x2 = 1, x3 = 2;
        for (int i = 0; i <= n - 3; i++) {
            x3 = x0 + x1 + x2;
            x0 = x1;
            x1 = x2;
            x2 = x3;
        }
        return x3;
    }
}
