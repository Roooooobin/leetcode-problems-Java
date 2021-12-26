import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode227 {

    public int calculate(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        int curNum = 0;
        char operator = '+';
        for (int i = 0; i < n; i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) {
                curNum = (curNum * 10) + curChar - '0';
            }
            if (!Character.isDigit(curChar) && !Character.isWhitespace(curChar) || i == n - 1) {
                if (operator == '-') {
                    stack.offerLast(-curNum);
                } else if (operator == '+') {
                    stack.offerLast(curNum);
                } else if (operator == '*') {
                    stack.offerLast(stack.pollLast() * curNum);
                } else if (operator == '/') {
                    stack.offerLast(stack.pollLast() / curNum);
                }
                operator = curChar;
                curNum = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pollLast();
        }
        return res;
    }
}
