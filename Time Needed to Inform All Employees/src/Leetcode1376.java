import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class Leetcode1376 {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            hash.putIfAbsent(manager[i], new ArrayList<>());
            hash.get(manager[i]).add(i);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[] {headID, 0});
        int res = 0;
        while (!q.isEmpty()) {
            int[] front = q.pollFirst();
            res = Math.max(res, front[1]);
            ArrayList<Integer> subordinates = hash.getOrDefault(front[0], new ArrayList<>());
            for (Integer subordinate : subordinates) {
                q.offerLast(new int[] {subordinate, front[1] + informTime[front[0]]});
            }
        }
        return res;
    }
}
