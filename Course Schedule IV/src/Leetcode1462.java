import java.util.*;

public class Leetcode1462 {

    public List<Boolean> checkIfPrerequisite(
            int numCourses, int[][] prerequisites, int[][] queries) {

        List<Boolean> res = new ArrayList<>();
        HashSet<Integer>[] pre = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            pre[i] = new HashSet<>();
        }
        for (int[] prerequisite : prerequisites) {
            pre[prerequisite[0]].add(prerequisite[1]);
        }
        for (int[] query : queries) {
            res.add(check(pre, query[0], query[1]));
        }
        return res;
    }

    public boolean check(HashSet<Integer>[] pre, int x, int y) {

        Deque<Integer> q = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();
        q.offerLast(x);
        seen.add(x);
        while (!q.isEmpty()) {
            int front = q.pollFirst();
            HashSet<Integer> set = pre[front];
            if (set.contains(y)) {
                //                pre[x].add(y);
                return true;
            }
            for (Integer i : set) {
                if (!seen.contains(i)) {
                    seen.add(i);
                    if (pre[i].contains(y)) {
                        return true;
                    }
                    q.offerLast(i);
                }
            }
        }
        return false;
    }
}
