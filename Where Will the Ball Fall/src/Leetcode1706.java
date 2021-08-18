public class Leetcode1706 {

    public int[] findBall(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            res[j] = goingDown(grid, j);
        }
        return res;
    }

    public int goingDown(int[][] grid, int j) {

        int n = grid[0].length;
        for (int[] cell : grid) {
            // either wall
            if (j == 0 && cell[j] == -1) {
                return -1;
            }
            if (j == n - 1 && cell[j] == 1) {
                return -1;
            }
            // V
            if (cell[j] == 1 && cell[j + 1] == -1) {
                return -1;
            }
            if (cell[j] == -1 && cell[j - 1] == 1) {
                return -1;
            }
            j += cell[j];
        }
        return j;
    }

    public static void main(String[] args) {
        Leetcode1706 ins = new Leetcode1706();
        int[][] arr = {
            {1, 1, 1, -1, -1},
            {1, 1, 1, -1, -1},
            {-1, -1, -1, 1, 1},
            {1, 1, 1, 1, -1},
            {-1, -1, -1, -1, -1}
        };
        System.out.println(ins.goingDown(arr, 0));
    }
}
