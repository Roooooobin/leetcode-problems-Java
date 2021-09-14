import java.util.Collections;
import java.util.HashSet;

public class Leetcode720 {

    class Solution {
        public String longestWord(String[] words) {
            String res = "";
            HashSet<String> wordSet = new HashSet<>();
            Collections.addAll(wordSet, words);
            for (String word : words) {
                if (word.length() >= res.length()) {
                    boolean flag = true;
                    for (int k = 1; k < word.length(); ++k) {
                        if (!wordSet.contains(word.substring(0, k))) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        if (word.length() > res.length()
                                || (word.length() == res.length() && word.compareTo(res) < 0)) {
                            res = word;
                        }
                    }
                }
            }
            return res;
        }
    }
}
