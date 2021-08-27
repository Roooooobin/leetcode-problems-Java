public class Leetcode1103 {

    public int[] distributeCandies(int candies, int n) {

        int[] res = new int[n];
        int cur = 0;
        while (candies > 0) {

            res[cur % n] += Math.min(++cur, candies);
            candies -= cur;
        }
        return res;
    }
}
