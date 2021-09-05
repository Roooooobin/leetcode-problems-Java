import java.util.Arrays;

public class Leetcode899 {

    // ...
    public String orderlyQueue(String s, int k) {

        int n = s.length();
        if (k == 1) {
            String res = s;
            for (int i = 0; i < n; i++) {
                String t = s.substring(i) + s.substring(0, i);
                if (t.compareTo(res) < 0) {
                    res = t;
                }
            }
            return res;
        } else {
            char[] sorted = s.toCharArray();
            Arrays.sort(sorted);
            return new String(sorted);
        }
    }
}
