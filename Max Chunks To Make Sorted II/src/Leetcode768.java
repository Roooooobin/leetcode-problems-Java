import java.util.Arrays;

public class Leetcode768 {

    public int maxChunksToSorted(int[] arr) {

        int n = arr.length;
        int[] sorted = new int[n];
        System.arraycopy(arr, 0, sorted, 0, n);
        Arrays.sort(sorted);
        long sum1 = 0, sum2 = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += sorted[i];
            if (sum1 == sum2) {
                res++;
            }
        }
        return res;
    }
}
