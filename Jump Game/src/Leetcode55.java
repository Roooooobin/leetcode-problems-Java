public class Leetcode55 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        if(n == 0 || nums[0] == 0) return false;
        int i = 0;
        int steps = nums[0];
        while(steps > 0 && i < n){
            if(i + nums[i] >= n-1) return true;
            steps--;
            i++;
            steps = Math.max(steps, nums[i]);
        }
        return false;
    }
}
