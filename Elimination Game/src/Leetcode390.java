public class Leetcode390 {

    /*
    https://leetcode-cn.com/problems/elimination-game/solution/xiao-chu-you-xi-by-leetcode-solution-ydpb/
     */
    public int lastRemaining(int n) {

        // 始终会保持一个等差数列
        int a = 1, an = n;
        int round = 0, cnt = n, diff = 1;
        while (cnt > 1) {
            if ((round & 1) == 0) {
                a = a + diff;
                an = (cnt % 2 == 0) ? an : an - diff;
            } else {
                a = (cnt % 2 == 0) ? a : a + diff;
                an = an - diff;
            }
            round++;
            cnt >>= 1;
            diff <<= 1;
        }
        return a;
    }
}
