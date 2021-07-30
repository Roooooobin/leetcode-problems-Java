public class Leetcode1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {

        long[] prefixSum = new long[candiesCount.length + 1];
        for (int i = 1; i < prefixSum.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + candiesCount[i - 1];
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {

            long pre = prefixSum[queries[i][0]] + 1;
            long cur = prefixSum[queries[i][0] + 1];
            // 最多能吃
            long leastEaten = (queries[i][1] + 1);
            long mostEaten = (long) (queries[i][1] + 1) * (long) queries[i][2];
            res[i] = leastEaten <= cur && mostEaten >= pre;
        }
        return res;
    }
}
