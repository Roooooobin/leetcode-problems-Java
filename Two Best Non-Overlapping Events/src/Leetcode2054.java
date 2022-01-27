import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode2054 {

    class Solution {
        public int maxTwoEvents(int[][] events) {

            int n = events.length;
            int res = 0;
            for (int[] event : events) {
                res = Math.max(res, event[2]);
            }
            Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
            // 记录坐标x之后最大的value
            TreeMap<Integer, Integer> maxAfter = new TreeMap<>();
            int curMaxVal = events[n - 1][2];
            for (int i = n - 1; i >= 0; i--) {
                curMaxVal = Math.max(curMaxVal, events[i][2]);
                maxAfter.put(events[i][0], curMaxVal);
            }
            for (int[] event : events) {
                Map.Entry<Integer, Integer> entry = maxAfter.ceilingEntry(event[1] + 1);
                if (entry != null) {
                    res = Math.max(res, event[2] + entry.getValue());
                }
            }
            return res;
        }
    }
}
