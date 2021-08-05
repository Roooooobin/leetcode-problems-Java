import java.util.ArrayList;
import java.util.List;

/*
https://leetcode-cn.com/problems/find-eventual-safe-states/solution/zhao-dao-zui-zhong-de-an-quan-zhuang-tai-yzfz/
 */
public class Leetcode802 {

    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {

            int n = graph.length;
            ArrayList<Integer> res = new ArrayList<>();
            int[] color = new int[n];
            for (int i = 0; i < n; ++i) {
                if (dfs(i, graph, color)) {
                    res.add(i);
                }
            }
            return res;
        }

        /*
        0: 未访问
        1: 位于递归途中或者在环上
        2: 搜索完毕，是一个安全节点
         */
        public boolean dfs(int x, int[][] graph, int[] color) {

            if (color[x] > 0) {
                return color[x] == 2;
            }
            color[x] = 1;
            for (int i : graph[x]) {
                if (!dfs(i, graph, color)) {
                    return false;
                }
            }
            color[x] = 2;
            return true;
        }
    }
}
