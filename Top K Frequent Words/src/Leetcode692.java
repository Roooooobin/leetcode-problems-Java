import java.util.*;

public class Leetcode692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.merge(word, 1, Integer::sum);
        }
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ?
                a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(count.entrySet());
        List<String> ans = new ArrayList<>();
        while (!maxHeap.isEmpty() && k-- > 0) {
            ans.add(maxHeap.poll().getKey());
        }
        return ans;
    }
}
