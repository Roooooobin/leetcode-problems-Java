import java.util.Arrays;
import java.util.Comparator;

public class Leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        int count = 0;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < intervals[prev][1]) {
                if (intervals[i][1] < intervals[prev][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }
        return count;
    }
}
