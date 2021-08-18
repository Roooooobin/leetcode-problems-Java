public class Leetcode1573 {

    public int numWays(String s) {

        final int MOD = 1000000007;
        char[] a = s.toCharArray();
        int count = 0;
        for (char c : a) {
            if (c == '1') {
                count++;
            }
        }
        if (count % 3 != 0) {
            return 0;
        }
        if (count == 0) {
            return (int) ((long) (a.length - 1) * (long) (a.length - 2) / 2 % MOD);
        }
        // 每部分1的个数
        int numOneEach = count / 3;
        count = 0;
        int last1 = -1, first2 = -1, last2 = -1, first3 = -1;
        for (int i = 0; i < a.length; i++) {
            char c = a[i];
            if (c == '1') {
                count++;
            }
            if (count == numOneEach && last1 == -1) {
                last1 = i;
            }
            if (count == numOneEach + 1 && first2 == -1) {
                first2 = i;
            }
            if (count == numOneEach * 2 && last2 == -1) {
                last2 = i;
            }
            if (count == numOneEach * 2 + 1 && first3 == -1) {
                first3 = i;
            }
        }
        return (int) ((long) (first2 - last1) * (long) (first3 - last2) % MOD);
    }

    public static void main(String[] args) {
        Leetcode1573 ins = new Leetcode1573();
        System.out.println(ins.numWays("100100010100110"));
    }
}
