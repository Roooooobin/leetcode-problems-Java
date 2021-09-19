public class Leetcode1405 {

    /*
    https://leetcode.com/problems/longest-happy-string/discuss/564277/C%2B%2BJava-a-greater-b-greater-c
     */
    public String longestDiverseString(int a, int b, int c) {

        return generate(a, b, c, "a", "b", "c");
    }

    // choose the most use 2, and the second most use 1
    public String generate(int a, int b, int c, String sa, String sb, String sc) {

        if (a < b) {
            return generate(b, a, c, sb, sa, sc);
        }
        if (b < c) {
            return generate(a, c, b, sa, sc, sb);
        }
        if (b == 0) {
            return repeat(sa, Math.min(2, a));
        }
        int useA = Math.min(2, a);
        int useB = a - useA >= b ? 1 : 0;
        return repeat(sa, useA) + repeat(sb, useB) + generate(a - useA, b - useB, c, sa, sb, sc);
    }

    public String repeat(String s, int n) {

        if (n == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(s);
        }
        return res.toString();
    }
}
