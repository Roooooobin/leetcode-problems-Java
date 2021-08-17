public class Leetcode1936 {

    public int addRungs(int[] rungs, int dist) {

        int res = 0;
        int cur = 0;
        int i = 0;
        int n = rungs.length;
        while (i < n) {

            if (cur + dist < rungs[i]) {
                res += (rungs[i] - cur) / dist;
                if ((rungs[i] - cur) % dist == 0) {
                    res--;
                }
            }
            cur = rungs[i++];
        }
        return res;
    }
}
