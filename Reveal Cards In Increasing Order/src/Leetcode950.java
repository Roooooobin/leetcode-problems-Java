import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode950 {

    public int[] deckRevealedIncreasing(int[] deck) {

        // 1 2 3 4 5: 1 5 2 4 3
        // 1 2 3 4: 1 3 2 4
        // 123456:
        // 按照结果反着模拟
        Arrays.sort(deck);
        int n = deck.length;
        int[] res = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.offerLast(i);
        }
        for (int x : deck) {
            res[q.pollFirst()] = x;
            if (!q.isEmpty()) {
                q.offerLast(q.pollFirst());
            }
        }
        return res;
    }
}
