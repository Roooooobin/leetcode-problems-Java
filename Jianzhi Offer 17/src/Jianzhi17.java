public class Jianzhi17 {

    public int[] printNumbers(int n) {

        int max = (int) myPow(10, n);
        int[] res = new int[max - 1];
        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / (myPow(x, -n - 1) * x);
        } else if ((n & 1) == 1) {
            return myPow(x, n - 1) * x;
        } else {
            return myPow(x * x, n / 2);
        }
    }
}
