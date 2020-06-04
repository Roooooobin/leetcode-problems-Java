import java.util.Arrays;

public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int rightProduct = 1, leftProduct = 1;
        for (int i=0; i<n; ++i) {
            ans[i] *= leftProduct;
            ans[n-1-i] *= rightProduct;
            leftProduct *= nums[i];
            rightProduct *= nums[n-1-i];
        }
        return ans;
    }
}
