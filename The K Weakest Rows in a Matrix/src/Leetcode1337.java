import java.util.Arrays;

public class Leetcode1337 {

    public int[] kWeakestRows(int[][] mat, int k) {

        int[] res = new int[k];
        int[] numOfSoldier = new int[mat.length];
        Integer[] indexes = new Integer[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int num : mat[i]) {
                if (num == 1) {
                    ++count;
                }
            }
            numOfSoldier[i] = count;
            indexes[i] = i;
        }
        Arrays.sort(
                indexes,
                (o1, o2) -> {
                    if (numOfSoldier[o1] == numOfSoldier[o2]) {
                        return o1 - o2;
                    } else {
                        return numOfSoldier[o1] - numOfSoldier[o2];
                    }
                });
        for (int i = 0; i < k; i++) {
            res[i] = indexes[i];
        }
        return res;
    }
}
