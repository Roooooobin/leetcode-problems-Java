import java.util.HashMap;
import java.util.HashSet;

public class Leetcode1525 {

    class Solution {
        public int numSplits(String s) {

            int res = 0;
            HashSet<Character> leftCount = new HashSet<>();
            HashMap<Character, Integer> rightCount = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int count = rightCount.getOrDefault(c, 0);
                rightCount.put(c, count + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                leftCount.add(c);
                int count = rightCount.get(c);
                if (count == 1) {
                    rightCount.remove(c);
                } else {
                    rightCount.put(c, count - 1);
                }
                if (leftCount.size() == rightCount.size()) {
                    res++;
                }
            }
            return res;
        }
    }
}
