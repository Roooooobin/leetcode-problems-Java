import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode797 {
    class Solution {

        List<List<Integer>> res;

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            res = new ArrayList<>();
            LinkedList<Integer> cur = new LinkedList<>();
            cur.offer(0);
            dfs(graph, 0, cur);
            return res;
        }

        public void dfs(int[][] graph, int idx, LinkedList<Integer> cur) {

            if (idx == graph.length - 1) {
                res.add(new LinkedList<>(cur));
            }
            for (int i = 0; i < graph[idx].length; i++) {
                cur.offer(graph[idx][i]);
                dfs(graph, graph[idx][i], cur);
                cur.pollLast();
            }
        }
    }
}
