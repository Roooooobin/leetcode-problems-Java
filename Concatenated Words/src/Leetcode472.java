import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
https://leetcode-cn.com/problems/concatenated-words/solution/gong-shui-san-xie-xu-lie-dpzi-fu-chuan-h-p7no/
 */
// 直接dp是能AC的，不过比较慢
public class Leetcode472 {

    HashSet<String> hashSet = new HashSet<>();
    private final int H = 131, OFFSET = 128;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        hashSet.addAll(Arrays.asList(words));
        ArrayList<String> res = new ArrayList<>();
        for (String s : words) {
            if (check(s)) {
                res.add(s);
            }
        }
        return res;
    }

    public boolean check(String s) {

        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[i] == -1) {
                continue;
            }
            StringBuilder cur = new StringBuilder();
            for (int j = i + 1; j <= n; j++) {
                cur.append(s.charAt(j - 1));
                if (hashSet.contains(cur.toString())) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
                if (dp[n] > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

// 想出思路是哈希优化+dp，但是还是不太熟悉具体做法
class Solution {
    HashSet<Long> hashSet = new HashSet<>();
    private final int H = 131, OFFSET = 128;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        for (String word : words) {
            long hash = 0;
            // 算出每个word的哈希值，加入set中
            for (int j = 0; j < word.length(); j++) {
                hash = hash * H + (word.charAt(j) - 'a') + OFFSET;
            }
            hashSet.add(hash);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String s : words) {
            if (check(s)) {
                res.add(s);
            }
        }
        return res;
    }

    public boolean check(String s) {

        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[i] == -1) {
                continue;
            }
            long cur = 0;
            for (int j = i + 1; j <= n; j++) {
                cur = cur * H + (s.charAt(j - 1) - 'a') + OFFSET;
                if (hashSet.contains(cur)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
                if (dp[n] > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
