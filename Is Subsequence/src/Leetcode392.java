public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        int idx = 0;
        for (int i=0; i<t.length(); ++i) {
            if (t.charAt(i) == s.charAt(idx)) ++idx;
            if (idx == s.length()) return true;
        }
        return false;
    }
}
