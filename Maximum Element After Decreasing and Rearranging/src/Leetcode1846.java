import java.util.Arrays;

public class Leetcode1846 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);
        arr[0] = 1;
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > res) {
                ++res;
            }
        }
        return res;
    }
}
