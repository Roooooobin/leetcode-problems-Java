public class Leetcode459 {

    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i != 0) {
                continue;
            }
            String t = s.substring(0, i);
            int j;
            for (j = i; j < n; j += i) {
                int k;
                for (k = 0; k < i; k++) {
                    if (t.charAt(k) != s.charAt(j + k)) {
                        break;
                    }
                }
                if (k != i) {
                    break;
                }
            }
            if (j == n) {
                return true;
            }
        }
        return false;
    }

    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            return (s + s).indexOf(s, 1) != s.length();
        }
    }

    // 链接：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
}
