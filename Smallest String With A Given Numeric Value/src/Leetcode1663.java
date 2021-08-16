public class Leetcode1663 {

    public String getSmallestString(int n, int k) {

        // 尽可能多的前缀a，尽可能多的后缀z
        int numOfa;
        for (numOfa = n; numOfa > 0; numOfa--) {
            if (numOfa + (n - numOfa) * 26 > k) {
                break;
            }
        }
        int numOfz = (k - numOfa) / 26;
        char c = (char) (k - numOfa - numOfz * 26 + 'a' - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numOfa; i++) {
            res.append('a');
        }
        if (numOfa + numOfz != n) {
            res.append(c);
        }
        for (int i = 0; i < numOfz; i++) {
            res.append('z');
        }
        return res.toString();
    }
}
