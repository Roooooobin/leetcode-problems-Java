import java.util.List;

public class Leetcode524 {

    public String findLongestWord(String s, List<String> dictionary) {

        String res = "";
        for (String word : dictionary) {
            if (isSubString(s, word)) {
                if (res.equals("") || res.length() < word.length()) {
                    res = word;
                } else if (res.length() == word.length() && res.compareTo(word) > 0) {
                    res = word;
                }
            }
        }
        return res;
    }

    // judge if t is the substring of s
    public boolean isSubString(String s, String t) {

        if (t.length() > s.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == t.length();
    }
}
