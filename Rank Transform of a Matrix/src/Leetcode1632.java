import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1632 {

    private static final int MIN = Integer.MIN_VALUE;

    /*
    WA，对于相同值的处理有误，需要用并查集辅助
     */
    //    public int[][] matrixRankTransform(int[][] matrix) {
    //
    //        int m = matrix.length, n = matrix[0].length;
    //        int[][] res = new int[m][n];
    //        for (int[] row : res) {
    //            Arrays.fill(row, MIN);
    //        }
    //        ArrayList<int[]> records = new ArrayList<>();
    //        for (int i = 0; i < m; i++) {
    //            for (int j = 0; j < n; j++) {
    //                records.add(new int[] {matrix[i][j], i, j});
    //            }
    //        }
    //        records.sort(Comparator.comparingInt(o -> o[0]));
    //
    //        int[] rowRankMax = new int[m], colRankMax = new int[n];
    //        int[] rowValMax = new int[m], colValMax = new int[n];
    //        Arrays.fill(rowRankMax, MIN);
    //        Arrays.fill(rowValMax, MIN);
    //        Arrays.fill(colRankMax, MIN);
    //        Arrays.fill(colValMax, MIN);
    //        for (int[] record : records) {
    //            int val = record[0];
    //            int row = record[1];
    //            int col = record[2];
    //            int rowColRankMax;
    //            int rowColValMAx;
    //            if (rowRankMax[row] > colRankMax[col]) {
    //                rowColRankMax = rowRankMax[row];
    //                rowColValMAx = rowValMax[row];
    //            } else {
    //                rowColRankMax = colRankMax[col];
    //                rowColValMAx = colValMax[col];
    //            }
    //            int fill;
    //            if (rowColRankMax != MIN) {
    //                if (rowColValMAx == val) {
    //                    fill = rowColRankMax;
    //                } else {
    //                    fill = rowColRankMax + 1;
    //                }
    //            } else {
    //                fill = 1;
    //            }
    //            res[row][col] = fill;
    //            rowRankMax[row] = fill;
    //            colRankMax[col] = fill;
    //            rowValMax[row] = val;
    //            colValMax[col] = val;
    //        }
    //
    //        return res;
    //    }

    class Solution {

        int[] p; // 并查集，用于合并相同大小的元素，保证相同大小的元素秩相同，且应为这些相同元素中秩的最大值
        int[] vals; // 对应下标的秩的值(下标使用indexes数组中的下标值表示)
        Integer[] indexes; // 转换二维下标为一维，存储下标，并按照矩阵中的值大小排序

        // 默写并查集
        public int find(int x) {
            if (x != p[x]) p[x] = find(p[x]);
            return p[x];
        }

        public void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa != pb) p[pb] = pa;
        }

        public int[][] matrixRankTransform(int[][] matrix) {

            int row = matrix.length, col = matrix[0].length;
            p = new int[row * col];
            vals = new int[row * col];
            indexes = new Integer[row * col];

            // 初始化indexes和并查集p
            for (int i = 0; i < row * col; i++) {
                indexes[i] = i;
                p[i] = i;
            }

            // 按照矩阵中的值排序indexs
            Arrays.sort(indexes, Comparator.comparingInt((Integer i) -> matrix[i / col][i % col]));

            // 由于经过排序后，小的元素先考虑，如果出现更新的位置(i, j)
            // 所在的行、列已经更新过，那么当前位置的秩必然大于等于已经更新过的位置的秩，因此记录i行，j列之前最后一次更新秩的索引，然后根据索引找到最后一次更新的秩的值，从行列取到最大值就是(i, j)位置的秩了。
            int[] rowMaxRank =
                    new int[row]; // rowMaxRank[i] = j 表示第i行目前(上一次更新的)最大的秩是 matrix[i][j] 的秩
            int[] colMaxRank =
                    new int[col]; // colMaxRank[j] = i 表示第j列目前(上一次更新的)最大的秩是 matrix[i][j] 的秩
            // 初始化
            Arrays.fill(rowMaxRank, -1);
            Arrays.fill(colMaxRank, -1);

            int pos = 0; // 遍历矩阵的索引
            while (pos < row * col) {
                int val = 1; // 每个位置的秩初始值
                int idx = indexes[pos]; // 获得排序后，第pos位置存储的索引

                // 将索引转换回矩阵的下标
                int i = idx / col;
                int j = idx % col;

                // 若i行中有更新过的位置
                if (rowMaxRank[i] != -1) {
                    // 获取最后一次更新过的下标，以及秩的值
                    int k = rowMaxRank[i];
                    int tmpIdx = i * col + k;
                    int tmpLeader = find(tmpIdx);
                    int tmpVal = vals[tmpLeader];

                    // 相同元素秩相等
                    if (matrix[i][j] == matrix[i][k]) {
                        // 合并相同元素
                        union(idx, tmpIdx);
                        val = tmpVal;
                    } else {
                        // 当前元素大于最后一次更新的元素，那么秩也要大于tmpVal
                        val = tmpVal + 1;
                    }
                }

                // 若j列中有更新过的位置
                if (colMaxRank[j] != -1) {
                    // 获取最后一次更新过的下标，以及秩的值
                    int k = colMaxRank[j];
                    int tmpIdx = k * col + j;
                    int tmpLeader = find(tmpIdx);
                    int tmpVal = vals[tmpLeader];

                    // 相同元素秩相等
                    if (matrix[i][j] == matrix[k][j]) {
                        // 合并相同元素
                        union(idx, tmpIdx);
                        // 由于在rowMaxRank[i] != -1 的条件中可能更新过了val，而我们需要的是行、列中最大的秩，故取max
                        val = Math.max(val, tmpVal);
                    } else {
                        // 当前元素大于最后一次更新的元素，那么秩也要大于tmpVal
                        // 取max理由同上
                        val = Math.max(val, tmpVal + 1);
                    }
                }

                // 更新最大秩的索引
                rowMaxRank[i] = j;
                colMaxRank[j] = i;

                // 更新当前索引位置的秩的值，由于有相同元素，故只更新当前位置leader的秩的值
                int leader = find(idx);
                vals[leader] = val;
                pos++;
            }

            // 将vals中每个元素的秩转化到二维矩阵返回
            int[][] res = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int idx = i * col + j;
                    res[i][j] = vals[find(idx)];
                }
            }
            return res;
        }
    }

    /*
    作者：charles-chou
    链接：https://leetcode-cn.com/problems/rank-transform-of-a-matrix/solution/java-bing-cha-ji-chao-xiang-xi-jiang-jie-by-charle/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
