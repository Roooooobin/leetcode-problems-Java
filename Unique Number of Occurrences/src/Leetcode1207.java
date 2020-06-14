import java.util.*;

public class Leetcode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : arr) {
            count.put(x, 1 + count.getOrDefault(x, 0));
        }
        Set<Integer> valueSet = new HashSet<>(count.values());
        return count.size() == valueSet.size();
    }
}
