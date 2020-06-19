import java.util.regex.*;

public class Leetcode125 {
    public boolean isPalindrome(String s) {
        String ss = s.replaceAll("\\W", "").toLowerCase();
        int i = 0, j = ss.length() - 1;
        while (i < j) {
            if (ss.charAt(i++) != ss.charAt(j--)) return false;
        }
        return true;
    }
}
