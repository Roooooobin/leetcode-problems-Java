import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Leetcode1562 {

    // AC, toooooooo slow!
    public int findLatestStep(int[] arr, int m) {

        int n = arr.length;
        if (m == n) {
            return n;
        }
        if (m > n) {
            return -1;
        }
        // 反着做，存0的位置，分割两端得到新的“一组”1
        ArrayList<Integer> pos = new ArrayList<>();
        pos.add(0);
        pos.add(n + 1);
        for (int i = arr.length - 1; i >= 0; i--) {
            int x = arr[i];
            int idx = lowerBound(pos, x);
            if (x - pos.get(idx - 1) - 1 == m || pos.get(idx) - x - 1 == m) {
                return i;
            }
            // this add is too slow
            pos.add(idx, x);
        }
        return -1;
    }

    public int lowerBound(ArrayList<Integer> nums, int tar) {

        int l = 0, r = nums.size() - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums.get(mid) < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    class Soluntion2 {

        public int findLatestStep(int[] arr, int m) {

            int n = arr.length;
            if (m == n) {
                return n;
            }
            if (m > n) {
                return -1;
            }
            // 反着做，存0的位置，分割两端得到新的“一组”1
            TreeSet<Integer> pos = new TreeSet<>();
            pos.add(0);
            pos.add(n + 1);
            // TreeSet的.lower, .higher
            for (int i = arr.length - 1; i >= 0; i--) {
                int x = arr[i];
                if (x - pos.lower(x) - 1 == m || pos.higher(x) - x - 1 == m) {
                    return i;
                }
                pos.add(x);
            }
            return -1;
        }
    }
}
