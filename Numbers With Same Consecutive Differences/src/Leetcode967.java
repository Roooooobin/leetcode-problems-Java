import java.util.ArrayList;

public class Leetcode967 {

    int n;
    int k;
    ArrayList<String> res = new ArrayList<>();

    public int[] numsSameConsecDiff(int n_, int k_) {

        n = n_;
        k = k_;
        char[] a = new char[n];
        for (int i = 1; i <= 9; i++) {
            if (i <= 9 - k || i >= k) {
                a[0] = (char) (i + '0');
                dfs(a, 1);
            }
        }
        int[] ans = new int[res.size()];
        int idx = 0;
        for (String s : res) {
            ans[idx++] = Integer.parseInt(s);
        }
        return ans;
    }

    public void dfs(char[] a, int idx) {

        if (idx >= n) {
            res.add(new String(a));
            return;
        }
        int cur = a[idx - 1] - '0';
        for (int i = 0; i <= 9; i++) {
            if (cur - i == k || i - cur == k) {
                a[idx] = (char) (i + '0');
                dfs(a, idx + 1);
                a[idx] = '0';
            }
        }
    }
}
