public class Leetcode137 {
    public int singleNumber(int[] nums) {
        final int SIZE = 32;    // for int
        final int TIMES = 3;    // can change to any times
        int ans = 0;
        for (int i=0; i<SIZE; ++i) {
            int sum = 0;
            int mask = (1 << i);
            for (int num : nums) {
                if ((num & mask) != 0) {
                    sum++;
                }
            }
            if (sum % TIMES == 1) {
                ans |= mask;
            }
        }
        return ans;
    }
}
