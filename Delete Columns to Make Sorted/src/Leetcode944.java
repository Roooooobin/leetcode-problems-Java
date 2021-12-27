public class Leetcode944 {

    public int minDeletionSize(String[] strs) {

        int res = 0;
        int n = strs[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
