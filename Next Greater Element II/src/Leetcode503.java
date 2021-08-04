import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode503 {

    class Solution {
        public int[] nextGreaterElements(int[] nums) {

            int n = nums.length;
            Deque<Integer> stack = new ArrayDeque<>();
            int[] res = new int[n];
            Arrays.fill(res, -1);
            // 因为存在重复元素，单调栈记录的是下标
            for (int i = 0; i < n * 2 - 1; ++i) {
                while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i % n]) {
                    int top = stack.pollLast();
                    res[top] = nums[i % n];
                }
                stack.addLast(i % n);
            }
            return res;
        }
    }
}
