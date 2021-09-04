public class Leetcode470 {
    class SolBase {}

    class Solution extends SolBase {
        public int rand10() {
            int ret = 40;
            while (ret >= 40) {
                ret = (rand7() - 1) * 7 + rand7() - 1;
            }
            return ret % 10 + 1;
        }
    }

    class Solution2 extends SolBase {
        public int rand10() {
            int a = rand7();
            while (a == 7) {
                a = rand7();
            }
            int b = rand7();
            while (b > 5) {
                b = rand7();
            }
            return ((a & 1) == 1) ? b : b + 5;
        }
    }
}
