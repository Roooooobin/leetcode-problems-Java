public class Leetcode152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int posMax = nums[0], negMin = nums[0], ans = nums[0];
        int prePosMax, preNegMin;
        for (int i=1; i<n; ++i) {
            prePosMax = posMax;
            preNegMin = negMin;
            posMax = Math.max(Math.max(prePosMax * nums[i], preNegMin * nums[i]), nums[i]);
            negMin = Math.min(Math.min(prePosMax * nums[i], preNegMin * nums[i]), nums[i]);
            if (ans < Math.max(posMax, negMin)) {
                ans = Math.max(posMax, negMin);
            }
        }
        return ans;
    }
}
