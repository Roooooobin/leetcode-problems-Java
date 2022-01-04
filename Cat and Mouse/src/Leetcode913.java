public class Leetcode913 {

    /*
    https://leetcode-cn.com/problems/cat-and-mouse/solution/gong-shui-san-xie-dong-tai-gui-hua-yun-y-0bx1/
     */

    class Solution {
        int N = 51;
        int[][][] dp = new int[2 * N * N][N][N];
        int[][] g;
        int n;

        public int catMouseGame(int[][] graph) {
            g = graph;
            n = graph.length;
            for (int k = 0; k < n * n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        dp[k][i][j] = -1;
                    }
                }
            }
            return dfs(0, 1, 2);
        }

        int dfs(int k, int a, int b) {
            int res = dp[k][a][b];
            if (a == 0) {
                res = 1;
            } else if (a == b) {
                res = 2;
            } else if (k >= 2 * n * n) {
                res = 0;
            } else if (res == -1) {
                if (k % 2 == 0) { // mouse
                    boolean win = false, draw = false;
                    for (int next : g[a]) {
                        int t = dfs(k + 1, next, b);
                        if (t == 1) {
                            win = true;
                        } else if (t == 0) {
                            draw = true;
                        }
                        if (win) {
                            break;
                        }
                    }
                    if (win) {
                        res = 1;
                    } else if (draw) {
                        res = 0;
                    } else {
                        res = 2;
                    }
                } else { // cat
                    boolean win = false, draw = false;
                    for (int next : g[b]) {
                        if (next == 0) {
                            continue;
                        }
                        int t = dfs(k + 1, a, next);
                        if (t == 2) {
                            win = true;
                        } else if (t == 0) {
                            draw = true;
                        }
                        if (win) {
                            break;
                        }
                    }
                    if (win) {
                        res = 2;
                    } else if (draw) {
                        res = 0;
                    } else {
                        res = 1;
                    }
                }
            }
            dp[k][a][b] = res;
            return res;
        }
    }
}
