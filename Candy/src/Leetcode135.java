import java.util.ArrayList;
import java.util.Comparator;

public class Leetcode135 {

    public int candy(int[] a) {

        int res = 0;
        int n = a.length;
        int[] candies = new int[n];
        ArrayList<int[]> l = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            l.add(new int[] {a[i], i});
        }
        l.sort(Comparator.comparingInt(o -> o[0]));
        for (int[] t : l) {
            int idx = t[1];
            int curVal = a[idx];
            int curCandy = 1;
            if (idx > 0) {
                if (curVal > a[idx - 1]) {
                    curCandy = Math.max(curCandy, candies[idx - 1] + 1);
                }
            }
            if (idx < n - 1) {
                if (curVal > a[idx + 1]) {
                    curCandy = Math.max(curCandy, candies[idx + 1] + 1);
                }
            }
            candies[idx] = curCandy;
            res += curCandy;
        }

        return res;
    }

    // O(n)
    class Solution {
        public int candy(int[] ratings) {

            int n = ratings.length;
            int[] left = new int[n];
            for (int i = 0; i < n; ++i) {
                if (i > 0 && ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }
            int right = 0, ret = 0;
            for (int i = n - 1; i >= 0; --i) {
                if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                    right++;
                } else {
                    right = 1;
                }
                ret += Math.max(left[i], right);
            }
            return ret;
        }
    }
}
