import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {
    public void backtracking(List<List<Integer>> ans, ArrayList<Integer> cur, int index, int[] candidates, int target){
        if(index > candidates.length || target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(cur));
        }
        else{
            for(int i=index; i<candidates.length; ++i){
                cur.add(candidates[i]);
                backtracking(ans, cur, i, candidates, target-candidates[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(ans, new ArrayList<>(), 0, candidates, target);
        return ans;
    }

    public static void main(String[] args) {
        Leetcode39 instance = new Leetcode39();
        List<List<Integer>> ans = instance.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(ans);
    }
}
