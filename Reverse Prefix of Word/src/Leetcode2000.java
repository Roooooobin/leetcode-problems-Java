public class Leetcode2000 {

    class Solution {
        public String reversePrefix(String word, char ch) {

            int idx = 0;
            for (; idx < word.length(); idx++) {
                if (word.charAt(idx) == ch) {
                    break;
                }
            }
            if (idx == word.length()) {
                return word;
            }
            StringBuilder res = new StringBuilder();
            for (int i = idx; i >= 0; i--) {
                res.append(word.charAt(i));
            }
            for (int i = idx + 1; i < word.length(); i++) {
                res.append(word.charAt(i));
            }
            return res.toString();
        }
    }
}
