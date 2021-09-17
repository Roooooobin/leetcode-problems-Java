import java.util.Arrays;

public class Leetcode1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] num = new int[100];
        for (int[] arr : dominoes) {
            Arrays.sort(arr);
            res += num[arr[0] * 10 + arr[1]]++;
        }
        return res;
    }
}
