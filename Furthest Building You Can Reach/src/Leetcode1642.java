import java.util.ArrayList;
import java.util.PriorityQueue;

public class Leetcode1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        ArrayList<Integer> steps = new ArrayList<>();
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] < heights[i + 1]) {
                steps.add(heights[i + 1] - heights[i]);
            }
        }

        PriorityQueue<Integer> forLadder = new PriorityQueue<>(); // default ascending
        int forBricksSum = 0;
        int forBricksCount = 0;
        for (int step : steps) {
            if (forLadder.size() < ladders) {
                forLadder.add(step);
            } else {
                int min = Integer.MAX_VALUE;
                if (!forLadder.isEmpty()) {
                    min = forLadder.peek();
                }
                if (step > min) {
                    forBricksSum += min;
                    if (forBricksSum > bricks) {
                        break;
                    }
                    forLadder.poll();
                    forBricksCount++;
                    forLadder.add(step);
                } else {
                    forBricksSum += step;
                    if (forBricksSum > bricks) {
                        break;
                    }
                    forBricksCount++;
                }
            }
        }
        int skip = forLadder.size() + forBricksCount;
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] < heights[i + 1]) {
                if (skip > 0) {
                    skip--;
                } else {
                    return i;
                }
            }
        }
        return heights.length - 1;
    }

    class Solution {

        public int furthestBuilding(int[] heights, int bricks, int ladders) {

            PriorityQueue<Integer> forLadder = new PriorityQueue<>(); // default ascending
            int forBricksSum = 0;
            int n = heights.length;
            for (int i = 1; i < n; i++) {
                int step = heights[i] - heights[i - 1];
                if (step > 0) {
                    forLadder.add(step);
                    if (forLadder.size() > ladders) {
                        forBricksSum += forLadder.peek();
                        forLadder.poll();
                    }
                    if (forBricksSum > bricks) {
                        return i - 1;
                    }
                }
            }

            return n - 1;
        }
    }

    public static void main(String[] args) {
        int[] h = new int[] {4, 12, 2, 7, 3, 18, 20, 3, 19};
        Leetcode1642 ins = new Leetcode1642();
        ins.furthestBuilding(h, 15, 2);
    }
}
