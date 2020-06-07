import java.util.*;

public class ZombieInMatrix {
    // Amazon OA Question: https://leetcode.com/discuss/interview-question/411357/
    public static int minHours(List<List<Integer>> grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int rows = grid.size();
        if (rows == 0) return -1;
        int columns = grid.get(0).size();
        if (columns == 0) return -1;
        for (int i=0; i<rows; ++i) {
            for (int j=0; j<columns; ++j) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new int[]{i, j});
                    count++;
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int min = 0;
        int target = rows * columns;
        while (true) {
            int len = queue.size();
            if (len == 0) break;
            if (count == target) return min;
            while (len > 0) {
                len--;
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int[] next = {cur[0] + direction[0], cur[1] + direction[1]};
                    int x = next[0];
                    int y = next[1];
                    if (x >= 0 && x < rows && y >= 0 && y < columns && grid.get(x).get(y) == 0) {
                        count++;
                        grid.get(x).set(y, 1);
                        queue.offer(next);
                    }
                }
            }
            min++;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(Arrays.asList(0, 1, 1, 0, 1)));
        lists.add(new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0)));
        lists.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1)));
        lists.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)));
        System.out.println(minHours(lists));
    }
}
