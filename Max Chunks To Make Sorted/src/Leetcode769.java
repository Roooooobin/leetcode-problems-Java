public class Leetcode769 {

    public int maxChunksToSorted(int[] arr) {

        int res = 0;
        int curSum = 0, tarSum = 0;
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            tarSum += i;
            if (curSum == tarSum) {
                res++;
            }
        }
        return res;
    }
}
