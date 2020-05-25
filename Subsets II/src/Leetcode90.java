import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode90 {
    public void backtracking(int[] nums, int start, LinkedList<Integer> curList, List<List<Integer>> ans) {
        if (start <= nums.length) {
            ans.add(new LinkedList<>(curList));
        }
        else return;
        for (int i=start; i<nums.length; ++i) {
            if (i > start && nums[i] == nums[i-1]) continue;
            curList.offer(nums[i]);
            backtracking(nums, i+1, curList, ans);
            curList.pollLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        backtracking(nums, 0, new LinkedList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        Leetcode90 leetcode90 = new Leetcode90();
        System.out.println(leetcode90.subsetsWithDup(new int[]{1, 2, 2, 2}));
    }
}
