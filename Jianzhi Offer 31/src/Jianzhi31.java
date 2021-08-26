import java.util.ArrayDeque;
import java.util.Deque;

public class Jianzhi31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        for (int x : pushed) {

            stack.offerLast(x);
            while (!stack.isEmpty() && (idx < popped.length && stack.peekLast() == popped[idx])) {
                idx++;
                stack.pollLast();
            }
        }
        return stack.isEmpty();
    }
}
