import java.util.Arrays;

public class Leetcode34 {
    public static int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        int firstPosition = l;
        l = 0;
        r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        int lastPosition = r;
        if(firstPosition == nums.length || nums[firstPosition] != target){
            return new int[]{-1, -1};
        }
        else return new int[]{firstPosition, lastPosition};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }
}
