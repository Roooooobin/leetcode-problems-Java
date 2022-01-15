public class Leetcode1716 {

    class Solution {
        public int totalMoney(int n) {

            int res = 0;
            res += (n / 7) * 28 + (n / 7 - 1) * 7 * (n / 7) / 2;
            int curMonday = n / 7 + 1;
            for (int i = 0; i < n % 7; i++) {
                res += curMonday;
                curMonday++;
            }
            return res;
        }
    }
}
