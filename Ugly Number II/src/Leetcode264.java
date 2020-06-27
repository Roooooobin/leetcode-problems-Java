public class Leetcode264 {
    public int nthUglyNumber(int n) {
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i=1; i<n; ++i) {
            ugly[i] = Math.min(ugly[idx2] * 2, Math.min(ugly[idx3] * 3, ugly[idx5] * 5));
            idx2 += (ugly[i] == ugly[idx2] * 2 ? 1 : 0);
            idx3 += (ugly[i] == ugly[idx3] * 3 ? 1 : 0);
            idx5 += (ugly[i] == ugly[idx5] * 5 ? 1 : 0);
        }
        return ugly[n-1];
    }
}
