import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dictionary = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(beginWord, 1));
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> cur = queue.poll();
            String word = cur.getKey();
            int step = cur.getValue();
            if (word.equals(endWord)) {
                return step;
            }
            visited.add(word);
            for (int i=0; i<word.length(); ++i) {
                for (int j=0; j<26; ++j) {
                    String newWord = word.substring(0, i) + (char)(j + 'a') + word.substring(i+1);
                    if (dictionary.contains(newWord) && !visited.contains(newWord)) {
                        visited.add(newWord);
                        queue.offer(  new Pair<>(newWord, step+1));
                    }
                }
            }
        }
        return 0;
    }
}
