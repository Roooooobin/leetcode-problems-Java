import java.util.HashSet;

public class Leetcode1461 {

    class Solution {
        public boolean hasAllCodes(String s, int k) {

            int count = 1 << k;
            HashSet<String> seen = new HashSet<>();
            StringBuilder cur = new StringBuilder();
            for (int i = 0; i < Math.min(k, s.length()); i++) {
                cur.append(s.charAt(i));
            }
            seen.add(cur.toString());
            for (int i = k; i < s.length(); i++) {
                cur = new StringBuilder(cur.substring(1));
                cur.append(s.charAt(i));
                seen.add(cur.toString());
                if (seen.size() == count) {
                    return true;
                }
            }
            return seen.size() == count;
        }
    }
}
