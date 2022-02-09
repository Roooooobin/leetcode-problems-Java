import java.util.ArrayList;
import java.util.List;

public class Leetcode1447 {

    class Solution {
        public List<String> simplifiedFractions(int n) {

            List<String> res = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    if (gcd(i, j) == 1) {
                        res.add(j + "/" + i);
                    }
                }
            }
            return res;
        }

        int gcd(int x, int y) {
            if (y == 0) {
                return x;
            }
            return gcd(y, x % y);
        }
    }
}
