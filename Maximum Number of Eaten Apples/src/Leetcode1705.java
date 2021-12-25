import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1705 {

    public int eatenApples(int[] apples, int[] days) {

        // int[] {rotNum, rotDate}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int n = apples.length;
        int day = 0, res = 0;
        while (day < n || !pq.isEmpty()) {
            if (day < n && apples[day] > 0) {
                pq.add(new int[] {apples[day], day + days[day] - 1});
            }
            while (!pq.isEmpty() && pq.peek()[1] < day) {
                pq.poll();
            }
            // eat apple
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (--cur[0] > 0 && cur[1] > day) {
                    pq.add(cur);
                }
                res++;
            }
            day++;
        }
        return res;
    }
}
