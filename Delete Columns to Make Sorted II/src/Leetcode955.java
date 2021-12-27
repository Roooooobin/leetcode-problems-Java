import java.util.Arrays;

public class Leetcode955 {

    public int minDeletionSize(String[] strs) {

        int res = 0;
        int lenWords = strs[0].length();
        int n = strs.length;
        String[] cur = new String[n];
        for (int i = 0; i < lenWords; i++) {
            String[] next = Arrays.copyOf(cur, n);
            for (int j = 0; j < n; j++) {
                next[j] += strs[j].charAt(i);
            }
            if (isSorted(next)) {
                cur = next;
            } else {
                res++;
            }
        }
        return res;
    }

    public boolean isSorted(String[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i - 1].compareTo(a[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
