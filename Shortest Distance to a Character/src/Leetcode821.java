import java.util.ArrayList;

public class Leetcode821 {

    /*
    public int[] shortestToChar(String s, char c) {

        int n = s.length();
        int[] res = new int[n];
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                pos.add(i);
                res[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                continue;
            }
            int idx = lowerBound(pos, i);
            int dis = Integer.MAX_VALUE;
            if (idx > 0) {
                dis = Math.min(dis, Math.abs(i - pos.get(idx - 1)));
            }
            dis = Math.min(dis, Math.abs(pos.get(idx) - i));
            res[i] = dis;
        }
        return res;
    }

    public int lowerBound(ArrayList<Integer> pos, int tar) {

        int n = pos.size();
        if (tar > pos.get(n - 1)) {
            return n - 1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {

            int mid = l + ((r - l) >> 1);
            if (pos.get(mid) < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

     */

    public int[] shortestToChar(String s, char c) {

        int n = s.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            res[i] = i - pos;
        }
        for (int i = pos - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            res[i] = Math.min(res[i], pos - i);
        }
        return res;
    }
}
