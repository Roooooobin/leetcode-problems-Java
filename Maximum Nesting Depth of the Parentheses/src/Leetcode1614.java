public class Leetcode1614 {

    class Solution {
        public int maxDepth(String s) {

            int max = 0;
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    res++;
                } else if (c == ')') {
                    res--;
                }
                max = Math.max(res, max);
            }
            return max;
        }
    }
}
