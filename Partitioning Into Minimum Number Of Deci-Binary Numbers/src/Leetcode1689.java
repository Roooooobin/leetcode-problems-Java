public class Leetcode1689 {

    class Solution {
        public int minPartitions(String n) {
            int max = n.charAt(0) - '0';
            if (max == 9) {
                return max;
            }
            for (int i = 0; i < n.length(); i++) {
                max = Math.max(max, n.charAt(i) - '0');
            }
            return max;
        }
    }
}
