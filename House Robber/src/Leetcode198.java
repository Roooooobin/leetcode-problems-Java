public class Leetcode198 {
    public int rob(int[] nums) {
        int pre = 0, cur = 0;
        for (int num : nums) {
            int tmp = Math.max(pre + num, cur);
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}
