import java.util.Arrays;

public class Leetcode647 {

    public int countSubstrings(String s) {

        int res = 0;
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(isPalindrome[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (isPalindrome[i][j]) {
                    ++res;
                }
            }
        }
        return res;
    }
}
