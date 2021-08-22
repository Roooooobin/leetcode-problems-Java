import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Leetcode1190 {

    // kinda slow
    public String reverseParentheses(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != ')') {
                stack.offerLast(c);
            } else {
                ArrayList<Character> l = new ArrayList<>();
                while (!stack.isEmpty() && stack.peekLast() != '(') {
                    l.add(stack.pollLast());
                }
                // delete (
                stack.pollLast();
                stack.addAll(l);
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pollFirst());
        }
        return res.toString();
    }

    class Solution {

        public String reverseParentheses(String s) {

            Deque<Integer> stack = new ArrayDeque<>();
            int n = s.length();
            StringBuilder res = new StringBuilder();
            char[] a = s.toCharArray();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    stack.offerLast(i);
                } else if (c == ')') {
                    int l = stack.pollLast() + 1;
                    int r = i - 1;
                    while (l <= r) {
                        char tmp = a[r];
                        a[r] = a[l];
                        a[l] = tmp;
                        l++;
                        r--;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (a[i] != '(' && a[i] != ')') {
                    res.append(a[i]);
                }
            }
            return res.toString();
        }
    }
}
