import java.util.ArrayList;
import java.util.List;

public class Leetcode969 {

    public List<Integer> pancakeSort(int[] a) {

        int n = a.length;
        int curMax = n;
        List<Integer> res = new ArrayList<>();
        while (!checkArray(a)) {

            int idxMax = 0;
            for (; idxMax < n; idxMax++) {
                if (a[idxMax] == curMax) {
                    break;
                }
            }
            for (int i = 0, j = idxMax; i < j; i++, j--) {
                swap(a, i, j);
            }
            if (idxMax != 0) {
                res.add(++idxMax);
            }
            for (int i = 0, j = curMax - 1; i < j; i++, j--) {
                swap(a, i, j);
            }
            res.add(curMax);
            curMax--;
        }
        return res;
    }

    boolean checkArray(int[] a) {

        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    void swap(int[] a, int i, int j) {

        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[] {3, 2, 4, 1};
        Leetcode969 ins = new Leetcode969();
        System.out.println(ins.pancakeSort(a).toString());
    }
}
