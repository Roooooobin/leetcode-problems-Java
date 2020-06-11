import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode739 {
    public static int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<n; ++i) {
            while (!stack.isEmpty() && T[i] > T[stack.peekFirst()]) {
                int top = stack.pollFirst();
                ans[top] = i - top;
            }
            stack.offerFirst(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 76, 77, 78, 79, 100})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{10, 9, 8, 7, 6, 5})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{1, 1, 1, 1, 1})));

    }
}
