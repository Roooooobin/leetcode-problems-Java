import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode1743 {

    public int[] restoreArray(int[][] adjacentPairs) {

        HashMap<Integer, ArrayList<Integer>> adjacentNumMap = new HashMap<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            countMap.put(pair[0], countMap.getOrDefault(pair[0], 0) + 1);
            countMap.put(pair[1], countMap.getOrDefault(pair[1], 0) + 1);
            ArrayList<Integer> l = adjacentNumMap.getOrDefault(pair[0], new ArrayList<>());
            l.add(pair[1]);
            adjacentNumMap.put(pair[0], l);
            ArrayList<Integer> l2 = adjacentNumMap.getOrDefault(pair[1], new ArrayList<>());
            l2.add(pair[0]);
            adjacentNumMap.put(pair[1], l2);
        }

        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int key : countMap.keySet()) {
            if (countMap.get(key) == 1) {
                tmp.add(key);
            }
        }
        res[0] = tmp.get(0);
        res[n - 1] = tmp.get(1);
        for (int i = 1; i < n - 1; ++i) {
            ArrayList<Integer> l = adjacentNumMap.get(res[i - 1]);
            if (i == 1) {
                res[i] = l.get(0);
            } else {
                int candidate1 = l.get(0);
                int candidate2 = l.get(1);
                res[i] = res[i - 2] == candidate1 ? candidate2 : candidate1;
            }
        }
        return res;
    }
}
