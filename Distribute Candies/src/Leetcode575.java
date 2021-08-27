import java.util.HashSet;

public class Leetcode575 {

    public int distributeCandies(int[] candyType) {

        int n = candyType.length;
        HashSet<Integer> countSet = new HashSet<>();
        for (int x : candyType) {
            countSet.add(x);
        }
        return Math.min(countSet.size(), n / 2);
    }
}
