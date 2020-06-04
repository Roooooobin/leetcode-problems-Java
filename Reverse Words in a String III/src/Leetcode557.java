import java.util.Arrays;
import java.util.stream.Collectors;

public class Leetcode557 {
    public String reverse(String word) {
        char[] s = word.toCharArray();
        int n = s.length;
        for (int i=0; i<n/2; ++i) {
            char tmp = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = tmp;
        }
        return new String(s);
    }

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        String[] reverseStrings = new String[strings.length];
        for (int i=0; i<strings.length; ++i) {
            reverseStrings[i] = reverse(strings[i]);
        }
        return String.join(" ", reverseStrings);
    }

    public String reverseWords2(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
