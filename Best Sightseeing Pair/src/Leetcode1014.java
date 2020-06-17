public class Leetcode1014 {
    public int maxScoreSightseeingPair(int[] A) {
        if (A.length == 0) return 0;
        int idx = 0;
        int max = A[0];
        int ans = Integer.MIN_VALUE;
        for (int i=1; i<A.length; ++i) {
            ans = Math.max(ans, A[i] + max + idx - i);
            if (A[i] > max-i+idx) {
                max = Math.max(max - i + idx, A[i]);
                idx = i;
            }
        }
        return ans;
    }

    // better
    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            int ans = 0, mx = A[0] + 0;
            for (int j = 1; j < A.length; ++j) {
                ans = Math.max(ans, mx + A[j] - j);
                // 边遍历边维护
                mx = Math.max(mx, A[j] + j);
            }
            return ans;
        }
    }
}
