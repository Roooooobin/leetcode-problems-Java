public class Leetcode1725 {

    class Solution {
        public int countGoodRectangles(int[][] rectangles) {

            int res = 0;
            int max = 0;
            for (int[] rectangle : rectangles) {
                max = Math.max(max, Math.min(rectangle[0], rectangle[1]));
            }
            for (int[] rectangle : rectangles) {
                if (Math.min(rectangle[0], rectangle[1]) == max) {
                    res++;
                }
            }
            return res;
        }
    }

    public int countGoodRectangles(int[][] rectangles) {

        int res = 0;
        int max = 0;
        for (int[] rectangle : rectangles) {
            int curMin = Math.min(rectangle[0], rectangle[1]);
            if (max == curMin) {
                res++;
            } else if (curMin > max) {
                max = curMin;
                res = 1;
            }
        }
        return res;
    }
}
