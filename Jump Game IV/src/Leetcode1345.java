import java.util.*;

public class Leetcode1345 {

    class Solution {
        public int minJumps(int[] arr) {

            HashMap<Integer, ArrayList<Integer>> val2IdxesMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                ArrayList<Integer> l = val2IdxesMap.getOrDefault(arr[i], new ArrayList<>());
                l.add(i);
                val2IdxesMap.put(arr[i], l);
            }
            Deque<int[]> q = new ArrayDeque<>();
            q.offerLast(new int[] {0, 0});
            HashSet<Integer> seen = new HashSet<>();
            seen.add(0);
            int n = arr.length;
            while (!q.isEmpty()) {
                int[] front = q.pollFirst();
                int idx = front[0], step = front[1];
                if (idx == n - 1) {
                    return step;
                }
                ArrayList<Integer> l = val2IdxesMap.get(arr[idx]);
                for (int i = l.size() - 1; i >= 0; i--) {
                    int t = l.get(i);
                    if (!seen.contains(t)) {
                        q.offerLast(new int[] {t, step + 1});
                        seen.add(t);
                    }
                }
                l.clear(); // must add otherwise TLE
                if (idx + 1 < n && !seen.contains(idx + 1)) {
                    q.offerLast(new int[] {idx + 1, step + 1});
                    seen.add(idx + 1);
                }
                if (idx - 1 >= 0 && !seen.contains(idx - 1)) {
                    q.offerLast(new int[] {idx - 1, step + 1});
                    seen.add(idx - 1);
                }
            }
            return -1;
        }
    }
}
