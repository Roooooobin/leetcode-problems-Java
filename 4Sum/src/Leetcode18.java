import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n-3; ++i){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<n-2; ++j){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int l = j + 1;
                int r = n - 1;
                while(l < r){
                    int sum = nums[l] + nums[r] + nums[i] + nums[j];
                    if(sum == target){
                        lists.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // duplicates
                        while(l < r && nums[l] == nums[l+1]) ++l;
                        while(l < r && nums[r] == nums[r-1]) --r;
                        ++l;
                        --r;
                    }
                    else if(sum < target){
                        ++l;
                    }
                    else{
                        --r;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Leetcode18 ins = new Leetcode18();
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = ins.fourSum(nums, 0);
        System.out.println(lists);
    }
}
