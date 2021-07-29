import java.util.HashMap;

/*
https://leetcode-cn.com/problems/beautiful-array/solution/piao-liang-shu-zu-by-leetcode/

 */
public class Leetcode932 {

    HashMap<Integer, int[]> hash;

    public int[] beautifulArray(int n) {
        hash = new HashMap<>();
        return helper(n);
    }

    public int[] helper(int n) {
        if (hash.containsKey(n)) {
            return hash.get(n);
        }
        int[] res = new int[n];
        if (n == 1) {
            res[0] = 1;
        } else {
            int i = 0;
            for (int x : helper((n + 1) >> 1)) {
                res[i++] = 2 * x - 1;
            }
            for (int x : helper(n >> 1)) {
                res[i++] = 2 * x;
            }
        }
        hash.put(n, res);
        return res;
    }
}
