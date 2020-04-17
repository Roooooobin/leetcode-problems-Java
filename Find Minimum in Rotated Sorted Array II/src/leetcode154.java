public class leetcode154 {
    public static int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int l = 0, r = n-1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r]){
                l = mid + 1;
            }
            else if(nums[mid] < nums[r]){
                r = mid;
            }
            else{
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(findMin(nums));
    }
}
