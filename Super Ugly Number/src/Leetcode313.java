import java.util.ArrayList;

public class Leetcode313 {

    public int nthSuperUglyNumber(int n, int[] primes) {

        ArrayList<Integer> nthSUN = new ArrayList<>();
        nthSUN.add(1);
        int[] curPos = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int minVal = Integer.MAX_VALUE;
            int curVal;
            for (int j = 0; j < primes.length; j++) {
                curVal = primes[j] * nthSUN.get(curPos[j]);
                if (curVal < minVal) {
                    minVal = curVal;
                }
            }
            for (int j = 0; j < primes.length; j++) {
                curVal = primes[j] * nthSUN.get(curPos[j]);
                if (curVal == minVal) {
                    curPos[j]++;
                }
            }
            nthSUN.add(minVal);
        }
        //        System.out.println(nthSUN.toString());

        return nthSUN.get(n - 1);
    }
}
