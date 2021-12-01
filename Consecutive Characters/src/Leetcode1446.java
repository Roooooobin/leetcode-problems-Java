public class Leetcode1446 {

    public int maxPower(String s) {

        int max = 1;
        int i = 1;
        char c = s.charAt(0);
        int cnt = 1;
        while (i < s.length()) {
            if (s.charAt(i) == c) {
                cnt++;
            } else {
                cnt = 1;
            }
            c = s.charAt(i);
            i++;
            max = Math.max(max, cnt);
        }
        max = Math.max(max, cnt);
        return max;
    }
}
