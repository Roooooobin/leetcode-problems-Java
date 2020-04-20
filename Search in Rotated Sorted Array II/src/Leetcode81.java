public class Leetcode81 {
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] == nums[l] && nums[mid] == nums[r]) {
                ++l;
                --r;
            }
            else if(nums[mid] <= nums[r]){  // 右半区间是有序的
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
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1};
        System.out.println(search(nums, 3));
    }
}
