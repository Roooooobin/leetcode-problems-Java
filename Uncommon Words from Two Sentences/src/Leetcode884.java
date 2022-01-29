import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode884 {

    class Solution {
        public String[] uncommonFromSentences(String s1, String s2) {

            ArrayList<String> res = new ArrayList<>();
            String[] words1 = s1.split(" ");
            String[] words2 = s2.split(" ");
            HashMap<String, Integer> count1 = new HashMap<>();
            HashMap<String, Integer> count2 = new HashMap<>();
            for (String word : words1) {
                count1.put(word, count1.getOrDefault(word, 0) + 1);
            }
            for (String word : words2) {
                count2.put(word, count2.getOrDefault(word, 0) + 1);
            }
            for (String word : count1.keySet()) {
                if (count1.get(word) == 1 && !count2.containsKey(word)) {
                    res.add(word);
                }
            }
            for (String word : count2.keySet()) {
                if (count2.get(word) == 1 && !count1.containsKey(word)) {
                    res.add(word);
                }
            }
            return res.toArray(new String[0]);
        }
    }
}
