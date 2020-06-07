import java.util.LinkedList;
import java.util.Queue;

public class Leetcode994 {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int target = n * m;
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 0) {
                    target--;
                }
            }
        }
        if (target == 0) return 0;
        int minute = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int count = queue.size();
            target -= count;
            if (target == 0) return minute;
            for (int i=0; i<count; ++i) {
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                        queue.offer(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }
            minute++;
        }
        return -1;
    }
}
