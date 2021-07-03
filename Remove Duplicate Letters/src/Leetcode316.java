public class Leetcode316 {
    public String removeDuplicateLetters(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (letters[i] == 1) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}
