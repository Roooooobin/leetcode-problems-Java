import java.util.Arrays;
import java.util.Random;

public class Leetcode528 {
    class Solution {

        Random random;
        int[] aSum;

        public Solution(int[] w) {
            random = new Random();
            for (int i=1; i<w.length; ++i) {
                w[i] += w[i-1];
            }
            aSum = w;
        }

        public int pickIndex() {
            int len = aSum.length;
            int randomIdx = random.nextInt(aSum[len-1]) + 1;
            int idx = Arrays.binarySearch(aSum, randomIdx);
            return idx >= 0 ? idx : -idx - 1;
        }
    }
}
