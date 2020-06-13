import java.util.ArrayList;
import java.util.List;

public class Leetcode89 {
    // inspired by https://leetcode.com/problems/gray-code/discuss/29881/An-accepted-three-line-solution-in-JAVA
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<(1 << n); ++i) {
            ans.add(i ^ (i>>1));
        }
        return ans;
    }
}
