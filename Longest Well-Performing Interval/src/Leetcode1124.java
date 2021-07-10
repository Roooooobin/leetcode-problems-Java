import java.util.HashMap;
import java.util.Map;

public class Leetcode1124 {

    public int longestWPI(int[] hours) {

        int[] preSum = new int[hours.length];
        for (int i = 0; i < hours.length; ++i) {
            if (hours[i] > 8) {
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
            int pre = 0;
            if (i != 0) {
                pre = preSum[i - 1];
            }
            preSum[i] = pre + hours[i];
        }

        int res = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < preSum.length; ++i) {
            int curSum = preSum[i];
            if (curSum > 0) {
                res = i + 1;
            } else {
                if (!hash.containsKey(curSum)) {
                    hash.put(curSum, i);
                }
                if (hash.containsKey(curSum - 1)) {
                    res = Math.max(res, i - hash.get(curSum - 1));
                }
            }
        }

        return res;
    }
}
