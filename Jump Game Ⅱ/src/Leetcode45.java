public class Leetcode45 {

    public static int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int curReach;
        int maxReach;
        int jumpCount = 1;
        int curIndex = 0;
        while(curIndex < n){
            if(curIndex + nums[curIndex] >= n-1) break;
            curReach = nums[curIndex];
            maxReach = curIndex + curReach;
            int nextIndex = curIndex + curReach;
            // 在可触及的范围内寻找下次能跳的最远的可能位置去跳
            while(curReach > 0){
                if(maxReach < curIndex + curReach + nums[curIndex+curReach]){
                    maxReach = curIndex + curReach + nums[curIndex+curReach];
                    nextIndex = curIndex + curReach;
                }
                curReach--;
            }
            jumpCount++;
            curIndex = nextIndex;
        }
        return jumpCount;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
