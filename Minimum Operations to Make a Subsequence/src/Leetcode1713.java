import java.util.ArrayList;
import java.util.HashMap;

/*
https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/solution/de-dao-zi-xu-lie-de-zui-shao-cao-zuo-ci-hefgl/
 */
public class Leetcode1713 {

    public int minOperations(int[] target, int[] arr) {

        HashMap<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            posMap.put(target[i], i);
        }
        ArrayList<Integer> LIS = new ArrayList<>();
        for (int x : arr) {
            if (posMap.containsKey(x)) {
                int idx = posMap.get(x);
                int it = lowerBound(LIS, idx);
                if (it != LIS.size()) {
                    LIS.set(it, idx);
                } else {
                    LIS.add(idx);
                }
            }
        }
        return target.length - LIS.size();
    }

    public int lowerBound(ArrayList<Integer> list, int tar) {
        int len = list.size();
        if (len == 0 || list.get(len - 1) < tar) {
            return len;
        }
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (list.get(mid) < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
