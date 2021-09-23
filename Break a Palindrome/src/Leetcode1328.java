public class Leetcode1328 {

    public String breakPalindrome(String palindrome) {

        if (palindrome.length() <= 1) {
            return "";
        }
        int breakPoint = -1;
        int n = palindrome.length();
        int middle = n / 2;
        for (int i = 0; i < middle; i++) {
            if (palindrome.charAt(i) != 'a') {
                breakPoint = i;
                break;
            }
        }
        if (breakPoint == -1) {
            return palindrome.substring(0, n - 1) + 'b';
        } else {
            return palindrome.substring(0, breakPoint) + 'a' + palindrome.substring(breakPoint + 1);
        }
    }
}
