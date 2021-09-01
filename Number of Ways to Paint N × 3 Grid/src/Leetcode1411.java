public class Leetcode1411 {

    /*
    https://leetcode-cn.com/problems/number-of-ways-to-paint-n-3-grid/solution/gei-n-x-3-wang-ge-tu-tu-se-de-fang-an-shu-by-leetc/
     */
    public int numOfWays(int n) {

        // ABC类，ABA类
        final int MOD = 1_000_000_007;
        long typeABC = 6, typeABA = 6;
        for (int i = 1; i < n; i++) {
            long newTypeABC = (typeABC * 2 + typeABA * 2) % MOD;
            long newTypeABA = (typeABC * 2 + typeABA * 3) % MOD;
            typeABC = newTypeABC;
            typeABA = newTypeABA;
        }
        return (int) ((typeABA + typeABC) % MOD);
    }
}
