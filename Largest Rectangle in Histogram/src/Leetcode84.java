import java.util.*;

public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int n = heights.length;
        int maxArea = 0;
        while (i <= n) {
            int h = (i == n? 0: heights[i]);
            if (stack.isEmpty() || heights[stack.peekFirst()] <= h) stack.offerFirst(i++);
            else {
                int tmp = stack.pollFirst();
                maxArea = Math.max(maxArea, heights[tmp] * (stack.isEmpty()? i: i - stack.peekFirst() - 1));
            }
        }
        return maxArea;
    }
}
