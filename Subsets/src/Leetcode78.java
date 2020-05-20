import java.util.LinkedList;
import java.util.List;

public class Leetcode78 {
    public void backtracking(int[] nums, int start, LinkedList<Integer> curList, List<List<Integer>> ans) {
        if (start <= nums.length) {
            ans.add(new LinkedList<>(curList));
        }
        else return;
        for (int i=start; i<nums.length; ++i) {
            curList.offer(nums[i]);
            backtracking(nums, i+1, curList, ans);
            curList.pollLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backtracking(nums, 0, new LinkedList<>(), ans);
        return ans;
    }
}
