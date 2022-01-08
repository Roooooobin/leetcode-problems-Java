import java.util.Arrays;

public class Leetcode785 {

    class Solution {
        public boolean isBipartite(int[][] graph) {

            int n = graph.length;
            int[] color = new int[n];
            Arrays.fill(color, -1);
            color[0] = 0;
            for (int i = 0; i < graph.length; i++) {
                for (int node : graph[i]) {
                    if (color[node] == -1) {
                        color[node] = (1 ^ color[i]);
                    } else if (color[node] == color[i]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
