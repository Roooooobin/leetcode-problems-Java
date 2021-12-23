import java.util.ArrayList;
import java.util.List;

public class Leetcode784 {

    public List<String> letterCasePermutation(String s) {

        ArrayList<String> res = new ArrayList<>();
        dfs(s, new StringBuilder(), 0, res);
        return res;
    }

    public void dfs(String s, StringBuilder cur, int idx, ArrayList<String> res) {

        if (idx == s.length()) {
            res.add(cur.toString());
            return;
        }
        char c = s.charAt(idx);
        if (!Character.isLetter(c)) {
            cur.append(c);
            dfs(s, cur, idx + 1, res);
        } else {
            StringBuilder next = new StringBuilder(cur);
            next.append(c);
            dfs(s, next, idx + 1, res);
            StringBuilder next2 = new StringBuilder(cur);
            next2.append(switchCase(c));
            dfs(s, next2, idx + 1, res);
        }
    }

    public char switchCase(char c) {
        if (Character.isLowerCase(c)) {
            return Character.toUpperCase(c);
        } else {
            return Character.toLowerCase(c);
        }
    }
}

class Leetcode784_ {

    class Solution {
        public List<String> letterCasePermutation(String s) {

            char[] a = s.toCharArray();
            ArrayList<String> res = new ArrayList<>();
            dfs(a, 0, res);
            return res;
        }

        public void dfs(char[] a, int start, ArrayList<String> res) {

            res.add(new String(a));
            for (int i = start; i < a.length; i++) {
                if (Character.isLetter(a[i])) {
                    a[i] = switchCase(a[i]);
                    dfs(a, i + 1, res);
                    a[i] = switchCase(a[i]);
                }
            }
        }

        public char switchCase(char c) {
            if (Character.isLowerCase(c)) {
                return Character.toUpperCase(c);
            } else {
                return Character.toLowerCase(c);
            }
        }
    }
}
