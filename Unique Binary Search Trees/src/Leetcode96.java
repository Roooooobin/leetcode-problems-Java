public class Leetcode96 {
    // 卡特兰数: h(i)= h(0)*h(i-1)+h(1)*h(i-2) + ... + h(i-1)h(0)
    public int numTrees(int n) {
        int[] catalan = new int[n+1];
        catalan[0] = 1;
        for (int i=1; i<=n; ++i) {
            for (int j=0; j<i; ++j) {
                catalan[i] += catalan[j] * catalan[i-j-1];
            }
        }
        return catalan[n];
    }
}
