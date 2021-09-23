import java.util.HashSet;

public class Leetcode1593 {

    int res = 1;

    public int maxUniqueSplit(String s) {

        dfs(s, 0, 0, new HashSet<>());
        return res;
    }

    public void dfs(String s, int idx, int count, HashSet<String> seen) {

        // 如果后面所有的字符单个成组都无法比当前最大值大，直接剪枝
        if (count + s.length() - idx <= res) {
            return;
        }
        if (idx == s.length()) {
            res = Math.max(res, count);
        }
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if (!seen.contains(sub)) {
                seen.add(sub);
                dfs(s, i + 1, count + 1, seen);
                seen.remove(sub);
            }
        }
    }
}
