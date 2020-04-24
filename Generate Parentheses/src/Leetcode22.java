import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    private List<String> list = new ArrayList<>();

    public void solve(String cur, int left, int right, int n){
        if(left + right == 2 * n){
            list.add(cur);
            return;
        }
        if(left < n){
            solve(cur+'(', left+1, right, n);
        }
        if(right < left){
            solve(cur+')', left, right+1, n);
        }
    }

    public List<String> generateParenthesis(int n) {
        solve("", 0, 0, n);
        return list;
    }

    public static void main(String[] args) {
        Leetcode22 ins = new Leetcode22();
        List<String> list = ins.generateParenthesis(5);
        System.out.println(list);
    }
}
