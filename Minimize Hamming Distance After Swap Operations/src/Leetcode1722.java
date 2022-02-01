import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode1722 {

    class Solution {

        int n;
        int[] par;

        public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

            n = source.length;
            par = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
            for (int[] allowedSwap : allowedSwaps) {
                combine(allowedSwap[0], allowedSwap[1]);
            }
            ArrayList<Integer>[] count = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                count[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                count[findRoot(i)].add(i);
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += calcDist(source, target, count[i]);
            }
            return res;
        }

        int calcDist(int[] s, int[] t, ArrayList<Integer> l) {

            int res = 0;
            HashMap<Integer, Integer> tmap = new HashMap<>();
            for (Integer idx : l) {
                tmap.put(t[idx], tmap.getOrDefault(t[idx], 0) + 1);
            }
            HashMap<Integer, Integer> smap = new HashMap<>();
            for (Integer idx : l) {
                smap.put(s[idx], smap.getOrDefault(s[idx], 0) + 1);
            }
            for (int key : tmap.keySet()) {
                res += Math.max(tmap.get(key) - smap.getOrDefault(key, 0), 0);
            }
            return res;
        }

        int findRoot(int i) {

            int r = i;
            while (r != par[r]) {
                r = par[r];
            }
            while (par[i] != r) {
                int t = par[i];
                par[i] = r;
                i = t;
            }
            return r;
        }

        void combine(int x, int y) {
            x = findRoot(x);
            y = findRoot(y);
            if (x == y) {
                return;
            }
            par[y] = x;
        }
    }
}
