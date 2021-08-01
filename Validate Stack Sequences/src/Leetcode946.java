import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        for (int x : pushed) {
            stack.offerLast(x);
            while (!stack.isEmpty() && (idx < popped.length && stack.peekLast() == popped[idx])) {
                ++idx;
                stack.pollLast();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Leetcode946 ins = new Leetcode946();
        int[] a = new int[] {1, 2, 3, 4, 5};
        int[] b = new int[] {4, 5, 3, 2, 1};
        ins.validateStackSequences(a, b);
    }
}
