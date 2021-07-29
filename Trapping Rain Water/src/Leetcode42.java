import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode42 {

    public int trap(int[] height) {

        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                int cur = stack.peekLast();
                stack.pollLast();
                if (stack.isEmpty()) break;
                int left = stack.peekLast();
                res += (Math.min(height[i], height[left]) - height[cur]) * (i - left - 1);
            }

            stack.offerLast(i);
        }
        return res;
    }
}
