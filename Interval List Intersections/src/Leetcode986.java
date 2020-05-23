import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> lists = new ArrayList<>();
        int i = 0, j = 0;
        int lo, hi;
        while (i < A.length && j < B.length) {
            lo = Math.max(A[i][0], B[j][0]);
            hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) {
                lists.add(new int[]{lo, hi});
            }
            if (A[i][1] < B[j][1]) {
                ++i;
            }
            else {
                ++j;
            }
        }
        return lists.toArray(new int[lists.size()][2]);
    }
}
