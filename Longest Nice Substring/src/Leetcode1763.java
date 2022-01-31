public class Leetcode1763 {

    class Solution {
        public String longestNiceSubstring(String s) {

            int maxLen = 0;
            int maxPos = 0;
            for (int i = 0; i < s.length(); i++) {
                int lowerBit = 0, upperBit = 0;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (Character.isUpperCase(c)) {
                        upperBit |= (1 << (c - 'A'));
                    } else {
                        lowerBit |= (1 << (c - 'a'));
                    }
                    if (lowerBit == upperBit && maxLen < j - i + 1) {
                        maxPos = i;
                        maxLen = j - i + 1;
                    }
                }
            }
            return s.substring(maxPos, maxPos + maxLen);
        }
    }
}
