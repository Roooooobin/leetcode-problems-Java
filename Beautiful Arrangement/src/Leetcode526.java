import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Leetcode526 {

    int res = 0;

    public int countArrangement(int n) {

        boolean[] seen = new boolean[n + 1];
        backtracking(n, 1, seen);
        return res;
    }

    public void backtracking(int n, int cur, boolean[] seen) {

        if (cur == n + 1) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!seen[i] & (i % cur == 0 || cur % i == 0)) {
                seen[i] = true;
                backtracking(n, cur + 1, seen);
                seen[i] = false;
            }
        }
    }
}

class Solution {

    public int countArrangement(int n) {
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int mask = 1; mask < (1 << n); mask++) {
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[(1 << n) - 1];
    }
}
