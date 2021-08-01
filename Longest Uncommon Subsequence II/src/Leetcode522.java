import java.util.HashMap;

public class Leetcode522 {

    public int findLUSlength(String[] strs) {

        HashMap<String, Boolean> isDuplicateMap = new HashMap<>();
        int res = -1;
        for (String str : strs) {
            if (isDuplicateMap.containsKey(str)) {
                isDuplicateMap.put(str, true);
                continue;
            }
            isDuplicateMap.put(str, false);
        }
        for (String s : strs) {
            if (isDuplicateMap.get(s)) continue;
            boolean isSub = false;
            for (String t : strs) {
                if (t.equals(s)) continue;
                if (isSubsequence(s, t)) {
                    isSub = true;
                    break;
                }
            }
            if (!isSub) {
                res = Math.max(res, s.length());
            }
        }
        return res;
    }

    // 判断s是不是t的子序列
    //    public boolean isSubsequence(String s, String t) {
    //        int idx = 0;
    //        for (int i = 0; i < s.length(); ++i) {
    //            boolean flag = false;
    //            for (int j = idx; j < t.length(); ++j) {
    //                if (s.charAt(i) == t.charAt(j)) {
    //                    flag = true;
    //                    idx = j + 1;
    //                    break;
    //                }
    //            }
    //            if (!flag) return false;
    //        }
    //        return true;
    //    }
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {

        String[] strs = new String[] {"aabbcc", "aabbcc", "bc", "bcc"};
        Leetcode522 ins = new Leetcode522();
        System.out.println(ins.isSubsequence("abc", "aabbcc"));
        System.out.println(ins.findLUSlength(strs));
    }
}
