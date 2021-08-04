import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Leetcode496 {

    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {

            Deque<Integer> stack = new ArrayDeque<>();
            HashMap<Integer, Integer> num2GreaterMap = new HashMap<>();
            for (int num : nums2) {
                while (!stack.isEmpty() && stack.peekLast() < num) {
                    num2GreaterMap.put(stack.pollLast(), num);
                }
                stack.addLast(num);
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = num2GreaterMap.getOrDefault(nums1[i], -1);
            }
            return res;
        }
    }
}
