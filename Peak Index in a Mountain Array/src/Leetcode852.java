public class Leetcode852 {

    public int peakIndexInMountainArray(int[] arr) {

        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (mid == 0) {
                l = mid + 1;
            } else if (mid == n - 1) {
                r = mid - 1;
            } else {
                if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                    l = mid + 1;
                } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
