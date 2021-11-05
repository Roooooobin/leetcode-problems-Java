import java.util.HashMap;

public class Leetcode1218 {

    public int longestSubsequence(int[] arr, int difference) {

        int n = arr.length;
        int[] dp = new int[n];
        int res = 1;
        HashMap<Integer, Integer> key2Idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int leftVal = arr[i] - difference;
            if (key2Idx.containsKey(leftVal)) {
                dp[i] = dp[key2Idx.get(leftVal)] + 1;
                res = Math.max(res, dp[i] + 1);
            }
            key2Idx.put(arr[i], i);
        }

        return res;
    }
}
