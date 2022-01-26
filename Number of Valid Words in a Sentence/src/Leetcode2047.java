public class Leetcode2047 {

    class Solution {
        public int countValidWords(String sentence) {

            int res = 0;
            String pattern1 = "[a-z]+-[a-z]+[!.,]?";
            String pattern2 = "[a-z]*[!.,]?";
            for (String word : sentence.split(" ")) {
                if (word.length() > 0 && (word.matches(pattern1) || word.matches(pattern2))) {
                    res++;
                }
            }
            return res;
        }
    }
}
