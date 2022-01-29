import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int n = heights.length;
        int maxArea = 0;
        while (i <= n) {
            int h = (i == n ? 0 : heights[i]);
            if (stack.isEmpty() || heights[stack.peekFirst()] <= h) {
                stack.offerFirst(i++);
            } else {
                int tmp = stack.pollFirst();
                maxArea =
                        Math.max(
                                maxArea,
                                heights[tmp] * (stack.isEmpty() ? i : i - stack.peekFirst() - 1));
            }
        }
        return maxArea;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int[] a = new int[n + 2];
        System.arraycopy(heights, 0, a, 1, n);
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[i] < a[stack.peekLast()]) {
                int h = a[stack.pollLast()];
                res = Math.max(res, h * (i - 1 - stack.peekLast()));
            }
            stack.offerLast(i);
        }
        return res;
    }
}
