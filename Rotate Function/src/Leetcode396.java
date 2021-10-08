public class Leetcode396 {

    public int maxRotateFunction(int[] a) {

        int curVal = 0;
        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            curVal += i * a[i];
            sum += a[i];
        }
        int res = curVal;
        for (int x : a) {
            curVal = curVal - sum + n * x;
            res = Math.max(res, curVal);
        }
        return res;
    }
}
