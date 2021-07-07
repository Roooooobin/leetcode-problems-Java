import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1711 {

    // 最大可能的2次幂是2^21
    private static final int MAXPOW = 21;
    private static final int MOD = (int) (1e9 + 7);

    public int countPairs(int[] deliciousness) {

        Map<Integer, Long> hash = new HashMap<>();
        for (int num : deliciousness) {
            hash.put(num, hash.getOrDefault(num, 0L) + 1);
        }

        long res = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i <= MAXPOW; ++i) {
            int numPower = 1 << i;
            for (int num : hash.keySet()) {
                int num2 = numPower - num;
                long cnt = hash.get(num);
                String pair = num + "|" + num2, pair2 = num2 + "|" + num;
                // 避免重复
                if (hash.containsKey(num2) && !visited.contains(pair2)) {
                    if (num == num2) {
                        res = (res + cnt * (cnt - 1) / 2) % MOD;
                    } else {
                        long cnt2 = hash.getOrDefault(num2, 0L);
                        res = (res + cnt * cnt2) % MOD;
                    }
                    visited.add(pair);
                }
            }
        }
        return (int) res;
    }
}

/*
the official solution is so much better
class Solution {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/count-good-meals/solution/da-can-ji-shu-by-leetcode-solution-fvg9/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
