import java.util.ArrayList;
import java.util.HashSet;

public class Jianzhi38 {

    HashSet<String> set = new HashSet<>();

    public void backtracking(String s, StringBuilder cur, Integer curBit, int idx, int n) {

        if (idx == n) {
            set.add(cur.toString());
        }
        for (int i = 0; i < n; i++) {
            int num = (1 << i);
            if ((curBit & num) == 0) {
                cur.append(s.charAt(i));
                curBit ^= num;
                backtracking(s, cur, curBit, idx + 1, n);
                cur.deleteCharAt(cur.length() - 1);
                curBit ^= num;
            }
        }
    }

    public String[] permutation(String s) {

        int n = s.length();
        backtracking(s, new StringBuilder(), 0, 0, n);
        ArrayList<String> res = new ArrayList<>(set);
        return res.toArray(new String[0]);
    }
}
