public class Leetcode1588 {

    public int sumOddLengthSubarrays(int[] arr) {

        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int res = 0;
        for (int k = 1; k <= n; k += 2) {

            for (int i = 0; i + k <= n; i++) {
                res += prefixSum[i + k] - prefixSum[i];
            }
        }
        return res;
    }
}
