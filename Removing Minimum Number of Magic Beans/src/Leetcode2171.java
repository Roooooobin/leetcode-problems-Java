import java.util.Arrays;

public class Leetcode2171 {

    class Solution {
        public long minimumRemoval(int[] beans) {

            long res = 100000000000L;
            int n = beans.length;
            Arrays.sort(beans);
            long[] prefixSum = new long[n + 1];
            for (int i = 0; i < beans.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + beans[i];
            }
            for (int i = 0; i < beans.length; i++) {
                long cur = 0;
                cur += prefixSum[i];
                cur += (prefixSum[n] - prefixSum[i + 1]) - (long) beans[i] * (n - 1 - i);
                res = Math.min(cur, res);
            }
            return res;
        }
    }
}
