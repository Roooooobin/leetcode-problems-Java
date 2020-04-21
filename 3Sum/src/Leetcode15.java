import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; ++i){
            if(nums[i] > 0) break;  // trim
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1, k = n - 1;
            int target = -nums[i];
            while(j < k){
                if(nums[j] + nums[k] == target){
//                    ArrayList<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[j]);
//                    list.add(nums[k]);
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[j+1]) ++j;
                    while(j < k && nums[k] == nums[k-1]) --k;
                    ++j;
                    --k;
                }
                else if(nums[j] + nums[k] < target){
                    ++j;
                }
                else{
                    --k;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
