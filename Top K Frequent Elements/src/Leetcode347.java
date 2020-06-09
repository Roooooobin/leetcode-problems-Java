import java.util.*;

public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
        }
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));
        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }
        int[] top = new int[k];
        for(int i=k-1; i>=0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}
