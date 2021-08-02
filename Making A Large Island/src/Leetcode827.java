// public class Leetcode827 {
//
//    int ans = 0;
//
//    public int largestIsland(int[][] grid) {
//
//        int n = grid.length;
//        // 只保存附近有1的0的位置
//        ArrayList<int[]> positionZero = new ArrayList<>();
//        int[][] savedGrid = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                savedGrid[i][j] = grid[i][j];
//                if (grid[i][j] == 1) {
//                    continue;
//                }
//                int countOfOne = 0;
//                if (i > 0 && grid[i - 1][j] == 1) {
//                    ++countOfOne;
//                }
//                if (i < n - 1 && grid[i + 1][j] == 1) {
//                    ++countOfOne;
//                }
//                if (j > 0 && grid[i][j - 1] == 1) {
//                    ++countOfOne;
//                }
//                if (j < n - 1 && grid[i][j + 1] == 1) {
//                    ++countOfOne;
//                }
//                // 周围存在1
//                if (countOfOne > 0) {
//                    int[] pos = new int[] {i, j};
//                    positionZero.add(pos);
//                }
//            }
//        }
//
//        int res = 1;
//        // 不改变任何0
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1) {
//                    dfs(i, j, grid);
//                    res = Math.max(res, ans);
//                }
//            }
//        }
//        for (int[] pos : positionZero) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    grid[i][j] = savedGrid[i][j];
//                }
//            }
//            grid[pos[0]][pos[1]] = 1;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (grid[i][j] == 1) {
//                        ans = 0;
//                        dfs(i, j, grid);
//                        res = Math.max(res, ans);
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    public void dfs(int i, int j, int[][] grid) {
//
//        grid[i][j] = 0;
//        ++ans;
//        int n = grid.length;
//        if (i > 0 && grid[i - 1][j] == 1) {
//            dfs(i - 1, j, grid);
//        }
//        if (i < n - 1 && grid[i + 1][j] == 1) {
//            dfs(i + 1, j, grid);
//        }
//        if (j > 0 && grid[i][j - 1] == 1) {
//            dfs(i, j - 1, grid);
//        }
//        if (j < n - 1 && grid[i][j + 1] == 1) {
//            dfs(i, j + 1, grid);
//        }
//    }
// }

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode-cn.com/problems/making-a-large-island/solution/zui-da-ren-gong-dao-by-leetcode/
 */
public class Leetcode827 {

    int[] dr = new int[] {-1, 0, 1, 0};
    int[] dc = new int[] {0, -1, 0, 1};
    int[][] grid;
    int N;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        N = grid.length;

        // 连通块编号
        int index = 2;
        int[] area = new int[N * N + 2];
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (grid[r][c] == 1) {
                    area[index] = dfs(r, c, index++);
                }
            }
        }

        int res = 0;
        // 不改变0
        for (int x : area) {
            res = Math.max(res, x);
        }
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    for (Integer move : calcNeighbors(r, c)) {
                        if (grid[move / N][move % N] > 1) {
                            seen.add(grid[move / N][move % N]);
                        }
                    }

                    int cur = 1;
                    // 四周不相同的连接块相加
                    for (int i : seen) {
                        cur += area[i];
                    }
                    res = Math.max(res, cur);
                }

        return res;
    }

    public int dfs(int r, int c, int index) {
        int ans = 1;
        grid[r][c] = index;
        List<Integer> neighbors = calcNeighbors(r, c);
        for (Integer move : neighbors) {
            if (grid[move / N][move % N] == 1) {
                grid[move / N][move % N] = index;
                ans += dfs(move / N, move % N, index);
            }
        }
        return ans;
    }

    public List<Integer> calcNeighbors(int r, int c) {
        ArrayList<Integer> neighbors = new ArrayList<>();
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                neighbors.add(nr * N + nc);
            }
        }

        return neighbors;
    }
}
