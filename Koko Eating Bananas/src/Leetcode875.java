import java.util.Arrays;

public class Leetcode875 {

    class Solution {

        int[] piles;
        int h;

        public int minEatingSpeed(int[] piles_, int h_) {

            if (h_ == piles_.length) {
                return Arrays.stream(piles_).max().getAsInt();
            }
            piles = piles_;
            h = h_;
            int lo = 1, hi = Integer.MAX_VALUE;
            while (lo <= hi) {
                int mid = lo + ((hi - lo) >> 1);
                if (check(mid)) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return lo;
        }

        public boolean check(int x) {

            int count = 0;
            for (int pile : piles) {
                count += pile / x + 1;
                if (pile % x == 0) {
                    count--;
                }
            }
            return count <= h;
        }
    }
}
