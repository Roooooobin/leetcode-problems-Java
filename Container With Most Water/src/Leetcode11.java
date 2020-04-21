public class Leetcode11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int max = 0;
        while(i < j){
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]){
                ++i;
            }
            else{
                --j;
            }
        }
        return max;
    }
}
