public class Leetcode41 {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; ++i){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = n+1;
            }
        }
        int idx;
        for(int i=0; i<n; ++i){
            if(Math.abs(nums[i]) == n+1) continue;
            idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) continue;
            nums[idx] *= -1;
        }
        for(int i=0; i<n; ++i){
            if(nums[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 0, -1, -2};
        System.out.println(firstMissingPositive(nums));
    }
}
