public class Leetcode1652 {

    public int[] decrypt(int[] code, int k) {

        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }
        int st = 1, ed = k, sum = 0;
        if (k < 0) {
            k = -k;
            st = n - k;
            ed = n - 1;
        }
        for (int i = st; i <= ed; i++) {
            sum += code[i];
        }
        // sliding window
        for (int i = 0; i < n; i++) {
            res[i] = sum;
            sum -= code[(st++) % n];
            sum += code[(++ed) % n];
        }
        return res;
    }
}
