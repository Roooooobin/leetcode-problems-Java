import java.util.ArrayList;
import java.util.List;

public class Leetcode386 {
    class Solution {
        public List<Integer> lexicalOrder(int n) {

            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 1; i < 10; ++i) {
                dfs(i, n, res);
            }
            return res;
        }

        public void dfs(int i, int n, ArrayList<Integer> res) {

            if (i > n) return;
            res.add(i);
            for (int j = 0; j < 10; ++j) {
                dfs(i * 10 + j, n, res);
            }
        }
    }
}
