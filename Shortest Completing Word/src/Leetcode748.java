public class Leetcode748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        int[] tar = calcLetters(licensePlate);
        int minLen = 0x3f3f3f3f;
        String res = "";
        for (String word : words) {
            int[] cur = calcLetters(word);
            int i;
            for (i = 0; i < 26; i++) {
                if (cur[i] < tar[i]) {
                    break;
                }
            }
            if (i == 26) {
                if (minLen > word.length()) {
                    res = word;
                    minLen = word.length();
                }
            }
        }
        return res;
    }

    public int[] calcLetters(String s) {

        s = s.toLowerCase();
        int[] letterCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                letterCount[c - 'a']++;
            }
        }
        return letterCount;
    }
}
