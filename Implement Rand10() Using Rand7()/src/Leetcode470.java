public class Leetcode470 {
    class SolBase {

    }

    class Solution extends SolBase {
        public int rand10() {
            int ret = 40;
            while (ret >= 40) {
                ret = (rand7() - 1) * 7 + rand7() - 1;
            }
            return ret % 10 + 1;
        }
    }
}
