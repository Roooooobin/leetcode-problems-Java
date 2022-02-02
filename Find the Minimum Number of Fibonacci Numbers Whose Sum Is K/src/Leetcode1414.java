import java.util.ArrayList;

public class Leetcode1414 {

    public int findMinFibonacciNumbers(int k) {

        ArrayList<Integer> fib = new ArrayList<>();
        int a = 0, b = 1, c;
        while (b <= k) {
            c = b;
            fib.add(b);
            b = (a + b);
            a = c;
        }
        int res = 0;
        for (int i = fib.size() - 1; i >= 0; i--) {
            if (fib.get(i) < k) {
                k -= fib.get(i);
                res++;
            } else if (fib.get(i) == k) {
                res++;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Leetcode1414 ins = new Leetcode1414();
        System.out.println(ins.findMinFibonacciNumbers(39));
    }
}
