import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Leetcode851 {

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        // person : richer people mapping
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
        int n = quiet.length;
        int[] inDegree = new int[n];
        for (int[] arr : richer) {
            int rich = arr[0];
            int poor = arr[1];
            inDegree[poor]++;
            ArrayList<Integer> l = m.getOrDefault(rich, new ArrayList<>());
            l.add(poor);
            m.put(rich, l);
        }
        int[] res = new int[quiet.length];
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        int count = 0;
        HashSet<Integer> seen = new HashSet<>();
        while (count < n) {
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0 && !seen.contains(i)) {
                    seen.add(i);
                    count++;
                    ArrayList<Integer> l = m.getOrDefault(i, new ArrayList<>());
                    if (l.size() == 0) {
                        break;
                    }
                    for (int x : l) {
                        inDegree[x]--;
                        if (quiet[res[i]] <= quiet[res[x]]) {
                            res[x] = res[i];
                        }
                    }
                }
            }
        }
        return res;
    }
}
