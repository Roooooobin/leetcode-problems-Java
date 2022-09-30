public class Leetcode1694 {

    class Solution {
        public String reformatNumber(String number) {

            StringBuilder digits = new StringBuilder();
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                if (Character.isDigit(c)) {
                    digits.append(c);
                }
            }
            int n = digits.length();
            int idx = 0;
            StringBuilder res = new StringBuilder();
            while (n > 0) {
                if (n > 4) {
                    res.append(digits.substring(idx, idx + 3)).append("-");
                    idx += 3;
                    n -= 3;
                } else {
                    if (n == 4) {
                        res.append(digits.substring(idx, idx + 2))
                                .append("-")
                                .append(digits.substring(idx + 2, idx + 4));
                    } else {
                        res.append(digits.substring(idx, idx + n));
                    }
                    break;
                }
            }
            return res.toString();
        }
    }
}
