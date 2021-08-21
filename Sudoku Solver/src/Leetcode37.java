import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode37 {

    int[] row = new int[9];
    int[] col = new int[9];
    int[] block = new int[9];
    ArrayList<int[]> spaces = new ArrayList<>();
    char[][] res = new char[9][9];
    boolean validFlag = false;

    public void solveSudoku(char[][] a) {

        int m = a.length;
        int n = a[0].length;
        // 使用位运算优化
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == '.') {
                    spaces.add(new int[] {i, j});
                } else {
                    int x = a[i][j] - '0';
                    int num = (1 << x);
                    flip(i, j, num);
                }
            }
        }
        dfs(a, 0);
        for (int i = 0; i < 9; i++) {
            System.arraycopy(res[i], 0, a[i], 0, 9);
        }
    }

    public void dfs(char[][] a, int idx) {

        if (idx == spaces.size()) {
            //            validFlag = true;
            for (int i = 0; i < 9; i++) {
                System.arraycopy(a[i], 0, res[i], 0, 9);
            }
            return;
        }
        int[] space = spaces.get(idx);
        int i = space[0], j = space[1];
        for (int x = 1; x <= 9; x++) {

            int num = (1 << x);
            if ((row[i] & num) != 0
                    || (col[j] & num) != 0
                    || (block[i / 3 * 3 + j / 3] & num) != 0) {
                continue;
            }
            a[i][j] = (char) (x + '0');
            flip(i, j, num);
            dfs(a, idx + 1);
            a[i][j] = '.';
            flip(i, j, num);
        }
    }

    public void flip(int i, int j, int num) {

        row[i] ^= num;
        col[j] ^= num;
        block[i / 3 * 3 + j / 3] ^= num;
    }

    public static void main(String[] args) {
        char[][] a =
                new char[][] {
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };

        Leetcode37 ins = new Leetcode37();
        ins.solveSudoku(a);
        System.out.println(Arrays.deepToString(a));
    }
}
