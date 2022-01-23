import java.util.ArrayList;
import java.util.List;

public class Leetcode1291 {

    class Solution {
        public List<Integer> sequentialDigits(int low, int high) {

            int digitLow = 0;
            int lowTmp = low, highTmp = high;
            while (lowTmp > 0) {
                digitLow++;
                lowTmp /= 10;
            }
            int digitHigh = 0;
            while (highTmp > 0) {
                digitHigh++;
                highTmp /= 10;
            }
            List<Integer> res = new ArrayList<>();
            ArrayList<Integer> candidates = produceInDigit(digitLow, digitHigh);
            for (Integer candidate : candidates) {
                if (candidate >= low && candidate <= high) {
                    res.add(candidate);
                }
            }
            return res;
        }

        public int firstInDigit(int digit) {
            int x = 1;
            for (int i = 1; i < digit; i++) {
                x = x * 10 + x % 10 + 1;
            }
            return x;
        }

        public ArrayList<Integer> produceInDigit(int digitLow, int digitHigh) {

            ArrayList<Integer> res = new ArrayList<>();
            for (int i = digitLow; i <= digitHigh; i++) {
                int x = firstInDigit(i);
                for (int j = 0; j < 10 - i; j++) {
                    res.add(x);
                    x += produceOne(i);
                }
            }
            return res;
        }

        public int produceOne(int digit) {
            int x = 1;
            for (int i = 1; i < digit; i++) {
                x = x * 10 + 1;
            }
            return x;
        }
    }
}
