import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode962 {

    /*
    https://leetcode-cn.com/problems/maximum-width-ramp/solution/java-dan-diao-zhan-er-fen-jie-fa-chang-shi-jie-shi/
    反证法解释单调栈
     */
    public int maxWidthRamp(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            if (stack.isEmpty() || nums[stack.peekLast()] > nums[i]) {
                stack.addLast(i);
            }
        }

        int res = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
                int cur = stack.pollLast();
                res = Math.max(res, i - cur);
            }
        }
        return res;
    }
}
