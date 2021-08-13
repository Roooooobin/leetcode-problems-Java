import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1673 {

    public int[] mostCompetitive(int[] nums, int k) {

        Deque<Integer> stack = new ArrayDeque<>();
        int i, n = nums.length;
        for (i = 0; i < n; i++) {
            if (stack.size() + n - i <= k) {
                break;
            }
            // 后面所有的都加上才恰好到k，必须停止
            while (!stack.isEmpty() && stack.peekLast() > nums[i]) {
                if (stack.size() + n - i <= k) {
                    break;
                }
                stack.pollLast();
            }
            if (stack.size() < k) {
                stack.offerLast(nums[i]);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx++] = stack.pollFirst();
        }
        for (; i < n; i++) {
            res[idx++] = nums[i];
        }
        return res;
    }
}

/*
[84,10,71,23,66,61,62,64,34,41,80,25,91,43,4,75,65,13,37,41,46,90,55,8,85,61,95,71]
24
 */
