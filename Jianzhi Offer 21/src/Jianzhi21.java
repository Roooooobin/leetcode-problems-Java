public class Jianzhi21 {

    public int[] exchange(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n - 1;
        for (int num : nums) {
            if ((num & 1) == 1) {
                res[l++] = num;
            } else {
                res[r--] = num;
            }
        }
        return res;
    }

    class Solution {
        public int[] exchange(int[] nums) {

            int n = nums.length;
            int l = 0, r = n - 1;
            while (l < r) {
                if ((nums[l] & 1) == 1) {
                    l++;
                    continue;
                }
                if ((nums[r] & 1) == 0) {
                    r--;
                    continue;
                }
                int tmp = nums[l];
                nums[l++] = nums[r];
                nums[r--] = tmp;
            }
            return nums;
        }
    }
}
