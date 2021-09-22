import java.util.HashSet;
import java.util.List;

public class Leetcode1239 {

    public int maxLength(List<String> arr) {

        int n = arr.size();
        int m = 1 << n;
        int res = 0;
        for (int i = 1; i < m; i++) {
            int x = i;
            HashSet<Character> seen = new HashSet<>();
            int idx = 0;
            boolean flag = true;
            while (x > 0) {
                if ((x & 1) == 1) {
                    String s = arr.get(idx);
                    for (int j = 0; j < s.length(); j++) {
                        if (seen.contains(s.charAt(j))) {
                            flag = false;
                            break;
                        }
                        seen.add(s.charAt(j));
                    }
                    if (!flag) {
                        break;
                    }
                }
                x >>= 1;
                idx++;
            }
            if (flag) {
                res = Math.max(res, seen.size());
            }
        }
        return res;
    }
}
