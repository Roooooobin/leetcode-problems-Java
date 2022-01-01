public class Leetcode1899 {

    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean flagFirst = false, flagSecond = false, flagThird = false;
        for (int[] triplet : triplets) {
            if (triplet[0] == target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                flagFirst = true;
            }
            if (triplet[1] == target[1] && triplet[0] <= target[0] && triplet[2] <= target[2]) {
                flagSecond = true;
            }
            if (triplet[2] == target[2] && triplet[1] <= target[1] && triplet[0] <= target[0]) {
                flagThird = true;
            }
        }
        return flagFirst && flagSecond && flagThird;
    }
}
