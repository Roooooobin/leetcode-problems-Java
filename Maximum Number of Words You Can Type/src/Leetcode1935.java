public class Leetcode1935 {

    class Solution {
        public int canBeTypedWords(String text, String brokenLetters) {

            String[] strings = text.split(" ");
            int res = 0;
            for (String s : strings) {
                int i;
                for (i = 0; i < brokenLetters.length(); ++i) {
                    if (s.indexOf(brokenLetters.charAt(i)) != -1) {
                        break;
                    }
                }
                if (i == brokenLetters.length()) {
                    ++res;
                }
            }
            return res;
        }
    }
}
