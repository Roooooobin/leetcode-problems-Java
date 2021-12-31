public class Leetcode2022 {

    public int[][] construct2DArray(int[] original, int m, int n) {

        if (original.length != m * n) {
            return new int[][] {};
        }
        int[][] res = new int[m][n];
        //        for (int i = 0; i < original.length; i++) {
        //            int row = i / n, col = i % n;
        //            res[row][col] = original[i];
        //        }
        for (int i = 0; i < original.length; i += n) {
            System.arraycopy(original, i, res[i / n], 0, n);
        }
        return res;
    }
}
