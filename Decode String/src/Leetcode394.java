import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode394 {

    public String decodeString(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ']') {
                StringBuilder cur = new StringBuilder();
                while (!stack.isEmpty() && stack.peekLast() != '[') {
                    char ch = stack.pollLast();
                    cur.insert(0, ch);
                }
                stack.pollLast();
                // find num
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peekLast())) {
                    numStr.insert(0, stack.pollLast());
                }
                int num = 0;
                for (int j = 0; j < numStr.length(); j++) {
                    num = num * 10 + numStr.charAt(j) - '0';
                }
                String strToAdd = cur.toString().repeat(num);
                for (int j = 0; j < strToAdd.length(); j++) {
                    stack.add(strToAdd.charAt(j));
                }
            } else {
                stack.offerLast(c);
            }
            i++;
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollFirst());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Leetcode394 ins = new Leetcode394();
        System.out.println(ins.decodeString("3[a]2[b5[bbc]]"));
    }
}
