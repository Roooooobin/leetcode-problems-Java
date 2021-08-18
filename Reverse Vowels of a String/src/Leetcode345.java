import java.util.HashSet;

public class Leetcode345 {

    public String reverseVowels(String s) {

        String vowels = "aeiouAEIOU";
        HashSet<Character> vowelSet = new HashSet<>();
        for (int i = 0; i < vowels.length(); i++) {
            vowelSet.add(vowels.charAt(i));
        }
        char[] a = s.toCharArray();
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < j && !vowelSet.contains(a[i])) {
                i++;
            }
            while (i < j && !vowelSet.contains(a[i])) {
                j--;
            }
            if (i < j) {
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(a);
    }
}
