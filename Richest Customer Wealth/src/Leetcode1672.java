public class Leetcode1672 {

    class Solution {
        public int maximumWealth(int[][] accounts) {

            int res = 0;
            int sum;
            for (int[] account : accounts) {
                sum = 0;
                for (int x : account) {
                    sum += x;
                }
                res = Math.max(res, sum);
            }
            return res;
        }
    }
}
