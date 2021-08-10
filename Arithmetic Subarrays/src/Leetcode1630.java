import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        ArrayList<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            res.add(check(nums, l[i], r[i]));
        }
        return res;
    }

    public boolean check(int[] a, int l, int r) {

        if (l == r) {
            return false;
        }
        int[] b = new int[r - l + 1];
        System.arraycopy(a, l, b, 0, r - l + 1);
        Arrays.sort(b);
        int diff = b[1] - b[0];
        for (int i = 1; i < b.length; i++) {
            if (b[i] - b[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
