import java.util.Arrays;

public class Leetcode1947 {

    int res = 0;
    int[][] students;
    int[][] mentors;

    public int maxCompatibilitySum(int[][] students_, int[][] mentors_) {

        students = students_;
        mentors = mentors_;
        int m = students_.length;
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = i;
        }
        allPermutations(a, 0);
        return res;
    }

    public void allPermutations(int[] a, int idx) {

        if (idx == a.length - 1) {
            int cur = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < students[i].length; j++) {
                    if (students[i][j] == mentors[a[i]][j]) {
                        cur++;
                    }
                }
            }
            System.out.println(Arrays.toString(a));
            res = Math.max(res, cur);
        }
        for (int i = idx; i < a.length; i++) {
            swap(a, idx, i);
            allPermutations(a, idx + 1);
            swap(a, idx, i);
        }
    }

    public void swap(int[] a, int i, int j) {

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
