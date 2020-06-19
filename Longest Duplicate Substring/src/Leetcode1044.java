import java.util.*;

// https://xingxingpark.com/Leetcode-1044-Longest-Duplicate-Substring/
public class Leetcode1044 {
    class Solution {
        private static final long MOD = (1 << 31) - 1;
        private static final long R = 256;

        public String longestDupSubstring(String S) {
            int l = 2;
            int r = S.length() - 1;
            int start = 0;
            int maxLen = 0;

            while (l <= r) {
                int len = l + (r - l) / 2;
                boolean found = false;

                Map<Long, List<Integer>> map = new HashMap<>();
                long hash = hash(S, len);
                map.put(hash, new ArrayList<>());
                map.get(hash).add(0);
                long RM = 1L;
                for (int i = 1; i < len; i++) RM = (R * RM) % MOD;

                loop:
                for (int i = 1; i + len <= S.length(); i++) {
                    hash = (hash + MOD - RM * S.charAt(i - 1) % MOD) % MOD;
                    hash = (hash * R + S.charAt(i + len - 1)) % MOD;
                    if (!map.containsKey(hash)) {
                        map.put(hash, new ArrayList<>());
                    } else {
                        for (int j : map.get(hash)) {
                            if (compare(S, i, j, len)) {
                                found = true;
                                start = i;
                                maxLen = len;
                                break loop;
                            }
                        }
                    }
                    map.get(hash).add(i);
                }
                if (found) l = len + 1;
                else r = len - 1;
            }
            return S.substring(start, start + maxLen);
        }

        private long hash(String S, int len) {
            long h = 0;
            for (int j=0; j<len; j++) h = (R * h + S.charAt(j)) % MOD;
            return h;
        }

        private boolean compare(String S, int i, int j, int len) {
            for (int count=0; count<len; count++) {
                if (S.charAt(i++) != S.charAt(j++)) return false ;
            }
            return true;
        }
    }
}
