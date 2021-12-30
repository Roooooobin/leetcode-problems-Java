public class Leetcode1578 {

    public int minCost(String colors, int[] neededTime) {

        int i = 0;
        int n = colors.length();
        int res = 0;
        while (i < n) {
            int r = i + 1;
            char cur = colors.charAt(i);
            while (r < n && colors.charAt(r) == cur) {
                r++;
            }
            if (i != r - 1) {
                int max = neededTime[i];
                for (int j = i; j < r; j++) {
                    max = Math.max(max, neededTime[j]);
                    res += neededTime[j];
                }
                res -= max;
            }
            i = r;
        }
        return res;
    }
}
