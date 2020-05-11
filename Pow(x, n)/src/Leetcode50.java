public class Leetcode50 {

    public double quickPow(double x, long n){
        if(n == 0) return 1.0;
        if(n == 1) return x;
        double val = quickPow(x, n/2);
        if(n % 2 == 1){
            return x * val * val;
        }
        else{
            return val * val;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0? quickPow(x, N): 1.0 / quickPow(x, -N);
    }

    public double quickPowIterative(double x, long n){
        double ans = 1.0;
        while(n > 0){
            if(n % 2 == 1){
                ans *= x;
            }
            x *= x;
            n /= 2;
        }
        return ans;
    }

    public double myPowIterative(double x, int n){
        long N = n;
        return N >= 0? quickPowIterative(x, N): 1.0 / quickPowIterative(x, -N);
    }

    public static void main(String[] args) {
        Leetcode50 leetcode50 = new Leetcode50();
        System.out.println(leetcode50.myPow(2, -11));
    }
}
