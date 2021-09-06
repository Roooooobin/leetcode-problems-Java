import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
https://leetcode-cn.com/problems/sliding-window-maximum/comments/
 */
public class Leetcode239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[] {};
        }
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!q.isEmpty() && nums[q.peekLast()] <= cur) {
                q.pollLast();
            }
            q.offerLast(i);
            // (index of the current max) + k must larger than i, otherwise is invalid
            if (q.peekFirst() + k <= i) {
                q.pollFirst();
            }
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[q.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode239 ins = new Leetcode239();
        System.out.println(Arrays.toString(ins.maxSlidingWindow(new int[] {1, -1}, 1)));
    }
}
