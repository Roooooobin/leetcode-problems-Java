public class Leetcode704 {

    public int search(int[] a, int tar) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] == tar) {
                return mid;
            } else if (a[mid] < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
