import java.util.Arrays;

public class Leetcode1011 {

    //    public int shipWithinDays(int[] weights, int days) {
    //
    //        int n = weights.length;
    //        if (n == 0) {
    //            return 0;
    //        }
    //        int[] prefixSum = new int[n];
    //        prefixSum[0] = weights[0];
    //        for (int i = 1; i < n; i++) {
    //            prefixSum[i] = prefixSum[i - 1] + weights[i];
    //        }
    //        // binary answers
    //        int l = Arrays.stream(weights).max().getAsInt();
    //        int r = Arrays.stream(weights).sum();
    //        while (l <= r) {
    //            int mid = l + ((r - l) >> 1);
    //            if (valid(prefixSum, days, mid)) {
    //                r = mid - 1;
    //            } else {
    //                l = mid + 1;
    //            }
    //        }
    //        return l;
    //    }
    //
    //    public boolean valid(int[] prefixSum, int days, int cap) {
    //
    //        int tar = cap;
    //        for (int i = 1; i < days; i++) {
    //            int idx = binarySearch(prefixSum, tar);
    //            if (idx >= 0) {
    //                tar = prefixSum[idx] + cap;
    //            } else {
    //                tar = prefixSum[-idx - 2] + cap;
    //            }
    //        }
    //
    //        return tar >= prefixSum[prefixSum.length - 1];
    //    }
    //
    //    public int binarySearch(int[] a, int tar) {
    //
    //        int l = 0, r = a.length - 1;
    //        while (l <= r) {
    //            int mid = l + ((r - l) >> 1);
    //            if (a[mid] < tar) {
    //                l = mid + 1;
    //            } else if (a[mid] > tar) {
    //                r = mid - 1;
    //            } else {
    //                return mid;
    //            }
    //        }
    //        return -(l + 1);
    //    }

    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;
        if (n == 0) {
            return 0;
        }
        // binary answers
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (valid(weights, days, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean valid(int[] a, int days, int cap) {

        int need = 1;
        int cur = 0;
        for (int x : a) {
            if (cur + x > cap) {
                need++;
                cur = 0;
            }
            cur += x;
        }
        return need <= days;
    }
}
