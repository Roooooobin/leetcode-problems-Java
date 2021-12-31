public class Leetcode1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int res = 0;
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        int target = k * threshold;
        for (int i = 0; i <= n - k; i++) {
            if (prefixSum[i + k] - prefixSum[i] >= target) {
                res++;
            }
        }
        return res;
    }
}
