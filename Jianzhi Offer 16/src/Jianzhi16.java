public class Jianzhi16 {

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
