public class Leetcode275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] == n - mid) {
                return citations[mid];
            }
            else if (citations[mid] < n - mid) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return n - l;
    }
}
