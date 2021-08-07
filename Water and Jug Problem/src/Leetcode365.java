import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Leetcode365 {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {

        HashSet<Pair<Integer, Integer>> seen = new HashSet<>();
        Deque<Pair<Integer, Integer>> q = new ArrayDeque<>();
        Pair<Integer, Integer> p = new Pair<>(jug1Capacity, jug2Capacity);
        q.offerLast(p);
        while (!q.isEmpty()) {
            Pair<Integer, Integer> front = q.pollFirst();
            int jug1 = front.getKey(), jug2 = front.getValue();
            if (jug1 == targetCapacity
                    || jug2 == targetCapacity
                    || (jug1 + jug2) == targetCapacity) {
                return true;
            }
            Pair<Integer, Integer> next;
            // 装满1
            next = new Pair<>(jug1Capacity, jug2);
            addToQueue(seen, q, next);
            // 装满2
            next = new Pair<>(jug1, jug2Capacity);
            addToQueue(seen, q, next);
            // 清空1
            next = new Pair<>(0, jug2);
            addToQueue(seen, q, next);
            // 清空2
            next = new Pair<>(jug1, 0);
            addToQueue(seen, q, next);
            // 1倒到2
            next =
                    new Pair<>(
                            Math.max(jug1 - (jug2Capacity - jug2), 0),
                            Math.min(jug1 + jug2, jug2Capacity));
            addToQueue(seen, q, next);
            // 2倒到1
            next =
                    new Pair<>(
                            Math.min(jug1 + jug2, jug1Capacity),
                            Math.max(jug2 - (jug1Capacity - jug1), 0));
            addToQueue(seen, q, next);
        }

        return false;
    }

    public void addToQueue(
            HashSet<Pair<Integer, Integer>> seen,
            Deque<Pair<Integer, Integer>> q,
            Pair<Integer, Integer> p) {

        if (!seen.contains(p)) {
            q.offerLast(p);
            seen.add(p);
        }
    }
}
