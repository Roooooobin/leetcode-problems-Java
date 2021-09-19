import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1544 {

    public String makeGood(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && isLowerUpperPair(stack.peekLast(), s.charAt(i))) {
                stack.pollLast();
                continue;
            }
            stack.offerLast(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollFirst());
        }
        return res.toString();
    }

    public boolean isLowerUpperPair(char a, char b) {

        return a - 'a' == b - 'A' || a - 'A' == b - 'a';
    }
}
