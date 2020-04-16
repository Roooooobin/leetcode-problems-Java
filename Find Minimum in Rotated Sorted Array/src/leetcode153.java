class Leetcode153 {
    public static int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int l = 0, r = n-1;
        if(nums[r] > nums[0]) return nums[0];
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            else if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }
            if(nums[mid] > nums[0]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return 0;   // will never reach here
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 2, 3};
        System.out.println(findMin(nums));
    }
}
