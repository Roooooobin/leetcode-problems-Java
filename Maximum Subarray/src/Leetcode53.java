public class Leetcode53 {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int pre = nums[0];
        int i = 1;
        while(i < n){
            pre = Math.max(nums[i], pre+nums[i]);
            ans = Math.max(pre, ans);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
