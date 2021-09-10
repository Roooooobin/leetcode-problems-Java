import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode823 {

    class Solution {
        public int numFactoredBinaryTrees(int[] A) {
            int MOD = 1_000_000_007;
            int N = A.length;
            Arrays.sort(A);
            long[] dp = new long[N];
            Arrays.fill(dp, 1);

            Map<Integer, Integer> index = new HashMap();
            for (int i = 0; i < N; ++i) index.put(A[i], i);

            for (int i = 0; i < N; ++i)
                for (int j = 0; j < i; ++j) {
                    if (A[i] % A[j] == 0) { // A[j] is left child
                        int right = A[i] / A[j];
                        if (index.containsKey(right)) {
                            dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                        }
                    }
                }

            long ans = 0;
            for (long x : dp) ans += x;
            return (int) (ans % MOD);
        }
    }

    public int numFactoredBinaryTrees(int[] arr) {

        final int MOD = 1_000_000_007;
        long res = 0;
        HashMap<Integer, Long> count = new HashMap<>();
        for (int x : arr) {
            count.put(x, 1L);
        }
        Arrays.sort(arr);
        for (int x : arr) {
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    int y = x / i;
                    if (!count.containsKey(i) || !count.containsKey(y)) {
                        continue;
                    }
                    long pro = 2L;
                    if (y == i) {
                        pro = 1L;
                    }
                    count.put(x, count.getOrDefault(x, 0L) + count.get(i) * count.get(y) * pro);
                }
            }
        }
        for (long v : count.values()) {
            res += v;
            res %= MOD;
        }
        return (int) res;
    }
}
