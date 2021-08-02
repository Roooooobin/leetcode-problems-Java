import java.util.Arrays;

public class Leetcode1051 {

    class Solution {
        public int heightChecker(int[] heights) {

            int[] heightsSorted = new int[heights.length];
            System.arraycopy(heights, 0, heightsSorted, 0, heights.length);
            Arrays.sort(heightsSorted);
            int count = 0;
            for (int i = 0; i < heights.length; i++) {
                if (heights[i] != heightsSorted[i]) {
                    ++count;
                }
            }
            return count;
        }
    }
}
