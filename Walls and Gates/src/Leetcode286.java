import java.util.LinkedList;
import java.util.Queue;

// Lintcode-663
public class Leetcode286 {
    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int distance = 1;
        final int INF = 2147483647;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (true) {
            int cnt = queue.size();
            if (cnt == 0) break;
            while (cnt > 0) {
                cnt--;
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int[] next = {cur[0] + direction[0], cur[1] + direction[1]};
                    int x = next[0];
                    int y = next[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && rooms[x][y] == INF) {
                        rooms[x][y] = distance;
                        queue.offer(next);
                    }
                }
            }
            distance++;
        }
    }
}
