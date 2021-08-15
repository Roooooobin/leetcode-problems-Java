public class Leetcode76 {

    public String minWindow(String s, String t) {

        int[] tar = new int[70];
        for (int i = 0; i < t.length(); i++) {
            tar[t.charAt(i) - 'A']++;
        }
        int[] cur = new int[70];
        int l = 0;
        int ansL = 0, ansR = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            cur[s.charAt(i) - 'A']++;
            if (satisfy(cur, tar)) {
                while (l <= i && satisfy(cur, tar)) {
                    if (min > (i - l + 1)) {
                        min = i - l + 1;
                        ansL = l;
                        ansR = i;
                    }
                    cur[s.charAt(l++) - 'A']--;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR + 1);
    }

    public boolean satisfy(int[] cur, int[] tar) {

        for (int i = 0; i < cur.length; i++) {
            if (tar[i] > 0 && tar[i] > cur[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //        String s = "ADOBECODEBADC", t = "ABCD";
        String s = "a", t = "a";
        Leetcode76 ins = new Leetcode76();
        String res = ins.minWindow(s, t);
        System.out.println(res);
    }
}
