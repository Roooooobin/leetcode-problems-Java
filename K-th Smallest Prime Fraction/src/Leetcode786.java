import java.util.Arrays;

public class Leetcode786 {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length * arr.length;
        int[][] a = new int[n][2];
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                a[cnt++] = new int[] {arr[i], arr[j]};
            }
        }
        Arrays.sort(a, (o1, o2) -> o1[0] * o2[1] - o1[1] * o2[0]);
        return a[k - 1];
    }
}
