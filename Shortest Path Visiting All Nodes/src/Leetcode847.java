import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes/solution/fang-wen-suo-you-jie-dian-de-zui-duan-lu-mqc2/
广度优先搜索
三元组（u, mask, dist）访问所有节点即mask为2^n-1，每次异或将第i位置为1，直到所有位均为1
经过情况不能重复，即对同一个节点u和该节点的经过情况mask只搜索一次
 */
public class Leetcode847 {
    class Solution {
        public int shortestPathLength(int[][] graph) {

            int n = graph.length;
            int res = 0;
            Deque<int[]> q = new ArrayDeque<>();
            boolean[][] seen = new boolean[n][1 << n];
            for (int i = 0; i < n; i++) {
                q.offerFirst(new int[] {i, 1 << i, 0});
                seen[i][1 << i] = true;
            }
            while (!q.isEmpty()) {
                int[] front = q.pollFirst();
                int curNode = front[0], mask = front[1], dist = front[2];
                if (mask == (1 << n) - 1) {
                    res = dist;
                    break;
                }
                for (int v : graph[curNode]) {
                    int curMask = mask | (1 << v);
                    if (!seen[v][curMask]) {
                        q.offerLast(new int[] {v, curMask, dist + 1});
                        seen[v][curMask] = true;
                    }
                }
            }
            return res;
        }
    }
}
