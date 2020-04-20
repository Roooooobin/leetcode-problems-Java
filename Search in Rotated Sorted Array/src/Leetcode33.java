public class Leetcode33 {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < nums[r]){  // 右半区间是有序的
                if(nums[mid] < target && nums[r] >= target){
                    l = mid + 1;
                }
                else r = mid - 1;
            }
            else{   // 左半区是有序的
                if(nums[mid] > target && nums[l] <= target){
                    r = mid - 1;
                }
                else l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(search(nums, 3));
    }
}
