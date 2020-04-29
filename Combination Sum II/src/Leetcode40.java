import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    public void backtracking(List<List<Integer>> ans, ArrayList<Integer> cur, int index, int[] candidates, int target){
        if(index > candidates.length || target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(cur));
        }
        else{
            for(int i=index; i<candidates.length; ++i){
                if(i > index && candidates[i] == candidates[i-1]) continue;
                cur.add(candidates[i]);
                backtracking(ans, cur, i+1, candidates, target-candidates[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(ans, new ArrayList<>(), 0, candidates, target);
        return ans;
    }

    public static void main(String[] args) {
        Leetcode40 instance = new Leetcode40();
        List<List<Integer>> ans = instance.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(ans);
    }
}
