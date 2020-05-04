import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backtracking(nums,0, lists);
        return lists;
    }

    public void backtracking(int [] nums, int k, List<List<Integer>> lists){
        if(k == nums.length-1){
            List<Integer> subList = new ArrayList<>();
            for(int x: nums){
                subList.add(x);
            }
            lists.add(subList);
        }
        else{
            for(int i=k; i<=nums.length-1; i++){
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                backtracking(nums,k+1, lists);
                temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
        }
    }

}
