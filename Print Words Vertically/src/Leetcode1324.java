import java.util.ArrayList;
import java.util.List;

public class Leetcode1324 {

    public List<String> printVertically(String s) {

        String[] strings = s.split(" ");
        int maxLen = 0;
        for (String string : strings) {
            maxLen = Math.max(maxLen, string.length());
        }
        char[][] words = new char[maxLen][strings.length];
        for (int i = 0; i < strings.length; i++) {

            for (int j = 0; j < maxLen; j++) {

                char c = ' ';
                if (j < strings[i].length()) {
                    c = strings[i].charAt(j);
                }
                words[j][i] = c;
            }
        }

        List<String> res = new ArrayList<>();
        for (char[] word : words) {
            StringBuilder sb = new StringBuilder();
            int r = word.length - 1;
            while (r > 0 && word[r] == ' ') {
                r--;
            }
            for (int i = 0; i <= r; i++) {
                sb.append(word[i]);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
