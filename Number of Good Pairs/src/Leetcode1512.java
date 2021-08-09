public class Leetcode1512 {

    //    public int numIdenticalPairs(int[] nums) {
    //
    //        int[] count = new int[101];
    //        for (int num : nums) {
    //            count[num]++;
    //        }
    //        int res = 0;
    //        for (int x : count) {
    //            res += (x - 1) * x / 2;
    //        }
    //        return res;
    //    }

    public int numIdenticalPairs(int[] nums) {

        int[] count = new int[101];
        int res = 0;
        for (int num : nums) {
            res += count[num];
            count[num]++;
        }
        return res;
    }
}
