public class Leetcode849 {

    class Solution {
        public int maxDistToClosest(int[] seats) {

            int i = 0;
            while (seats[i] == 0) {
                i++;
            }
            int pre = i;
            int res = i;
            for (; i < seats.length; i++) {
                if (seats[i] == 1) {
                    res = Math.max((i - pre) / 2, res);
                    pre = i;
                }
            }
            res = Math.max(res, seats.length - pre - 1);
            return res;
        }
    }
}
