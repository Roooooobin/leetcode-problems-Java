import java.util.Arrays;
import java.util.HashSet;

public class Leetcode676 {

    class MagicDictionary {

        /** Initialize your data structure here. */
        HashSet<String> dictionary;

        public MagicDictionary() {
            dictionary = new HashSet<>();
        }

        public void buildDict(String[] words) {
            dictionary.addAll(Arrays.asList(words));
        }

        public boolean search(String searchWord) {
            for (String word : dictionary) {
                if (charDifferenceIsOne(searchWord, word)) {
                    return true;
                }
            }
            return false;
        }

        // check s can change exactly one character to become t
        public boolean charDifferenceIsOne(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (count == 1) {
                        return false;
                    }
                    count++;
                }
            }
            return count == 1;
        }
    }

    /**
     * Your MagicDictionary object will be instantiated and called as such: MagicDictionary obj =
     * new MagicDictionary(); obj.buildDict(dictionary); boolean param_2 = obj.search(searchWord);
     */
}
