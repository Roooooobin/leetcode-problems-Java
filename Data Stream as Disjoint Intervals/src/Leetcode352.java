import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Leetcode352 {

    class SummaryRanges {

        TreeSet<int[]> ts;

        public SummaryRanges() {

            ts = new TreeSet<>((Comparator.comparingInt(o -> o[0])));
            // add -oo and oo
            ts.add(new int[] {-23, -23});
            ts.add(new int[] {10023, 10023});
        }

        public void addNum(int val) {

            int[] cur = new int[] {val, val};
            int[] prev = ts.floor(cur);
            int[] next = ts.ceiling(cur);
            if ((prev[0] <= val && val <= prev[1]) || (next[0] <= val && val <= next[1])) {
                // cur in the prev or next, do nothing
            } else if (prev[1] + 1 == val && val + 1 == next[0]) {
                // combine prev and next
                prev[1] = next[1];
                ts.remove(next);
            } else if (prev[1] + 1 == val) {
                // combine prev and val
                prev[1] = val;
            } else if (val + 1 == next[0]) {
                // combine val and next
                next[0] = val;
            } else {
                ts.add(cur);
            }
        }

        public int[][] getIntervals() {

            int n = ts.size();
            int[][] res = new int[n - 2][2];
            int idx = 0;
            for (int[] t : ts) {
                if (idx == 0 || idx == n - 1) {
                    idx++;
                    continue;
                }
                res[idx - 1][0] = t[0];
                res[idx - 1][1] = t[1];
                idx++;
            }
            return res;
        }

        // iterator
        public int[][] getIntervalsIterator() {

            int n = ts.size();
            int[][] res = new int[n - 2][2];
            Iterator<int[]> iterator = ts.iterator();
            iterator.next();
            for (int i = 0; i < n - 1; i++) {
                res[i] = iterator.next();
            }
            return res;
        }
    }
}
