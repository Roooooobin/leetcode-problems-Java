import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode1167 {
    // Leetcode premium, Lintcode-1872
    public int MinimumCost(List<Integer> sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        int ans = 0;
        while (pq.size() > 1) {
            int top = pq.poll();
            int top2 = pq.poll();
            ans += (top + top2);
            pq.offer(top + top2);
        }
        return ans;
    }
}
