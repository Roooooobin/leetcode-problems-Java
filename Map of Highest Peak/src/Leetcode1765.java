import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Leetcode1765 {

    class Solution {
        public int[][] highestPeak(int[][] isWater) {

            int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int m = isWater.length, n = isWater[0].length;
            Deque<Integer> q = new ArrayDeque<>();
            HashSet<Integer> seen = new HashSet<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isWater[i][j] == 1) {
                        q.offerLast(i * n + j);
                        isWater[i][j] = 0;
                        seen.add(i * n + j);
                    }
                }
            }
            while (!q.isEmpty()) {
                int front = q.pollFirst();
                int x = front / n, y = front % n;
                for (int[] direction : directions) {
                    int nx = x + direction[0], ny = y + direction[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen.contains(nx * n + ny)) {
                        isWater[nx][ny] = isWater[x][y] + 1;
                        q.offerLast(nx * n + ny);
                        seen.add(nx * n + ny);
                    }
                }
            }
            return isWater;
        }
    }
}
