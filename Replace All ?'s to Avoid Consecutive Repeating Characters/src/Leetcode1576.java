public class Leetcode1576 {

    public String modifyString(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '?') {
                sb.append(c);
            } else {
                sb.append(chooseLetter(s, sb, i));
            }
        }
        return sb.toString();
    }

    public Character chooseLetter(String s, StringBuilder cur, int idx) {

        char chosen = 'a';
        int c1 = -1, c2 = -1;
        if (idx - 1 >= 0) {
            c1 = cur.charAt(idx - 1) - 'a';
        }
        if (idx + 1 < s.length()) {
            c2 = s.charAt(idx + 1) - 'a';
        }
        for (int i = 0; i < 26; i++) {
            if (i != c1 && i != c2) {
                return (char) ('a' + i);
            }
        }
        return chosen;
    }
}
