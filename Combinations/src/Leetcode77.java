import java.util.LinkedList;
import java.util.List;

public class Leetcode77 {
    private List<List<Integer>> ans = new LinkedList<>();

    public void backtracking(int n, int k, int st, LinkedList<Integer> curList) {
        if (k == 0) {
            ans.add(new LinkedList<>(curList));
        }
        else {
            for (int i=st; i<=n; ++i) {
                curList.offer(i);
                backtracking(n, k-1, i+1, curList);
                curList.pollLast();
            }
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) return new LinkedList<>();
        backtracking(n, k, 1, new LinkedList<>());
        return ans;
    }

    public static void main(String[] args) {
        Leetcode77 leetcode77 = new Leetcode77();
        List<List<Integer>> lists = leetcode77.combine(4, 2);
        System.out.println(lists);
    }
}
