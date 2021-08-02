import java.util.Arrays;
import java.util.HashMap;

public class Leetcode436 {

    class Solution {
        public int[] findRightInterval(int[][] intervals) {

            int n = intervals.length;
            int[] res = new int[n];
            HashMap<Integer, Integer> val2IdxMap = new HashMap<>();
            val2IdxMap.put(-1, -1);
            int[] leftVals = new int[n];
            for (int i = 0; i < intervals.length; i++) {
                val2IdxMap.put(intervals[i][0], i);
                leftVals[i] = intervals[i][0];
            }
            Arrays.sort(leftVals);
            for (int i = 0; i < intervals.length; i++) {
                int idx = lowerBound(leftVals, intervals[i][1]);
                if (idx == n) {
                    res[i] = -1;
                    continue;
                }
                res[i] = val2IdxMap.get(leftVals[idx]);
            }
            return res;
        }

        public int lowerBound(int[] a, int tar) {
            int l = 0, r = a.length - 1;
            if (tar > a[r]) {
                return a.length;
            }
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (a[mid] < tar) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }
}
