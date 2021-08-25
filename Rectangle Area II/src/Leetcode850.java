import java.util.*;

public class Leetcode850 {

    class Solution {
        public int rectangleArea(int[][] rectangles) {
            final int MOD = 1_000_000_007;
            int N = rectangles.length;
            Set<Integer> xVals = new HashSet<>();
            Set<Integer> yVals = new HashSet<>();

            for (int[] rec : rectangles) {
                xVals.add(rec[0]);
                xVals.add(rec[2]);
                yVals.add(rec[1]);
                yVals.add(rec[3]);
            }

            Integer[] imapx = xVals.toArray(new Integer[0]);
            Arrays.sort(imapx);
            Integer[] imapy = yVals.toArray(new Integer[0]);
            Arrays.sort(imapy);

            Map<Integer, Integer> xMap = new HashMap<>();
            Map<Integer, Integer> yMap = new HashMap<>();
            for (int i = 0; i < imapx.length; ++i) {
                xMap.put(imapx[i], i);
            }
            for (int i = 0; i < imapy.length; ++i) {
                yMap.put(imapy[i], i);
            }

            boolean[][] grid = new boolean[imapx.length][imapy.length];
            for (int[] rec : rectangles) {
                for (int x = xMap.get(rec[0]); x < xMap.get(rec[2]); ++x) {
                    for (int y = yMap.get(rec[1]); y < yMap.get(rec[3]); ++y) {
                        grid[x][y] = true;
                    }
                }
            }

            long ans = 0;
            for (int x = 0; x < grid.length; ++x) {
                for (int y = 0; y < grid[0].length; ++y) {
                    if (grid[x][y]) {
                        ans += (long) (imapx[x + 1] - imapx[x]) * (imapy[y + 1] - imapy[y]);
                    }
                }
            }

            ans %= MOD;
            return (int) ans;
        }
    }
}
