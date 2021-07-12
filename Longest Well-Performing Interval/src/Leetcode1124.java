import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1124 {

    public int longestWPI2(int[] hours) {

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

    // 单调栈
    public int longestWPI(int[] hours) {

        int[] preSum = new int[hours.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < hours.length; ++i) {
            if (hours[i] > 8) {
                hours[i] = 1;
            } else {
                hours[i] = -1;
            }
            preSum[i + 1] = preSum[i] + hours[i];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < preSum.length; ++i) {
            if (stack.isEmpty() || preSum[stack.peekLast()] > preSum[i]) {
                stack.offerLast(i);
            }
        }
        int res = 0;
        for (int i = preSum.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && preSum[stack.peekLast()] < preSum[i]) {
                int cur = stack.pollLast();
                res = Math.max(res, i - cur);
            }
        }

        return res;
    }
}
