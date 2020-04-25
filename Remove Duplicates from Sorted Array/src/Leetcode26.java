public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int cnt = 0;    // number of duplicates
        for(int i=1; i<n; ++i){
            if(nums[i] == nums[i-1]) cnt++;
            else nums[i-cnt] = nums[i];
        }
        return n - cnt;
    }
//    public int removeDuplicates(int[] nums) {
//        int n = nums.length;
//        int cnt = 0;    // number of duplicates
//        int i = 1;
//        while(true){
//            while(i < n && nums[i] == nums[i - 1]) {
//                cnt++;
//                ++i;
//            }
//            if(i >= n) break;
//            nums[i-cnt] = nums[i];
//            ++i;
//        }
//        return n - cnt;
//    }
}
