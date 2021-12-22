public class Leetcode686 {

    public int repeatedStringMatch(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int res = 0;
        int maxLen = 2 * a.length() + b.length();
        while (sb.length() < maxLen) {
            sb.append(a);
            res++;
            if (sb.toString().contains(b)) {
                return res;
            }
        }
        return -1;
    }
}
