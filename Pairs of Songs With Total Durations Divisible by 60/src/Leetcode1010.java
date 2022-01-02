public class Leetcode1010 {

    //    public int numPairsDivisibleBy60(int[] time) {
    //
    //        int[] residueMap = new int[60];
    //        int MOD = 60;
    //        for (int x : time) {
    //            residueMap[x % MOD]++;
    //        }
    //        int res = residueMap[0] * (residueMap[0] - 1) / 2;
    //        for (int i = 1; i < MOD / 2; i++) {
    //            res += residueMap[i] * residueMap[MOD - i];
    //        }
    //        res += residueMap[MOD / 2] * (residueMap[MOD / 2] - 1) / 2;
    //        return res;
    //    }

    public int numPairsDivisibleBy60(int[] time) {

        int[] residueMap = new int[60];
        int MOD = 60;
        int res = 0;
        for (int x : time) {
            if (x % MOD == 0) {
                res += residueMap[0];
            } else {
                res += residueMap[MOD - (x % MOD)];
            }
            residueMap[x % MOD]++;
        }
        return res;
    }
}
