public class Leetcode978 {

    public int maxTurbulenceSize(int[] arr) {

        int res = 1;
        int i = 1;
        int n = arr.length;
        if (n > 1 && arr[1] != arr[0]) {
            res = 2;
        }
        while (i < n - 1) {
            int cur = 1;
            if (arr[i] != arr[i - 1]) {
                cur = 2;
            }
            while (i < n - 1) {
                long product = (long) (arr[i] - arr[i - 1]) * (long) (arr[i + 1] - arr[i]);
                if (product >= 0) {
                    break;
                }
                i++;
                cur++;
            }
            res = Math.max(res, cur);
            i++;
        }
        return res;
    }
}
