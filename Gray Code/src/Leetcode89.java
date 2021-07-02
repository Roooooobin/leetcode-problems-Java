import java.util.ArrayList;
import java.util.List;

public class Leetcode89 {
    // inspired by https://leetcode.com/problems/gray-code/discuss/29881/An-accepted-three-line-solution-in-JAVA
    public List<Integer> grayCodeBit(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<(1 << n); ++i) {
            ans.add(i ^ (i>>1));
        }
        return ans;
    }

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        List<Integer> pre = grayCode(n-1);
        List<Integer> cur = new ArrayList<>(pre);
        int numAdd = 1 << (n-1);
        for (int i = pre.size()-1; i >= 0; --i) {
            cur.add(pre.get(i) + numAdd);
        }
        return cur;
    }
}
