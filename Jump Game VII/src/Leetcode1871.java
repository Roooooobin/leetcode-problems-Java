public class Leetcode1871 {

    // 不能每次跳到能跳的最远，因为有最小跳，跳太远下一次可能不够跳

    /*
    https://leetcode-cn.com/problems/jump-game-vii/solution/hua-chuang-si-xiang-dp-bu-xu-yao-qian-zh-j865/
     */
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();
        if (s.charAt(n - 1) != '0') {
            return false;
        }
        boolean[] reach = new boolean[n];
        reach[0] = true;
        int cnt = 1; // 滑窗中可达坐标的个数
        for (int i = minJump; i < n; i++) {
            if (s.charAt(i) == '0' && cnt > 0) {
                reach[i] = true;
            }
            if (i >= maxJump && reach[i - maxJump]) {
                cnt--;
            }
            if (reach[i - minJump + 1]) {
                cnt++;
            }
        }
        return reach[n - 1];
    }
}
