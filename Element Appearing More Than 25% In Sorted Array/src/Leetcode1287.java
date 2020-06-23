public class Leetcode1287 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int len = n / 4;
        for (int i=0; i<n-len; ++i) {
            if (arr[i] == arr[i+len]) {
                return arr[i];
            }
        }
        return -1;
    }

    public int findSpecialInteger2(int[] arr) {
        int len = arr.length / 4;
        for (int num : arr) {
            int dist = upperBound(arr, num) - lowerBound(arr, num) ;
            if (dist > len) {
                return num;
            }
        }
        return -1;
    }

    public int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
