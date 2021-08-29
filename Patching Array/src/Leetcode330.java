public class Leetcode330 {

    /*
    https://leetcode-cn.com/problems/patching-array/comments/ by Alfeim
     */
    public int minPatches(int[] nums, int n) {

        // 当前能覆盖到的最大值
        long farthestReach = 0;
        int len = nums.length;
        int res = 0;
        long i = 1;
        int pos = 0;
        while (i <= n) {

            if (pos >= len || i < nums[pos]) {
                res++;
                farthestReach += i;
            } else {
                farthestReach += nums[pos++];
            }
            i = farthestReach + 1;
        }
        return res;
    }
}
