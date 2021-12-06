public class Leetcode1217 {

    public int minCostToMoveChips(int[] position) {

        // move even to 0, odd to 1
        int chips_on_0 = 0, chips_on_1 = 0;
        for (int x : position) {
            if ((x & 1) == 1) {
                chips_on_1++;
            } else {
                chips_on_0++;
            }
        }
        return Math.min(chips_on_0, chips_on_1);
    }
}
