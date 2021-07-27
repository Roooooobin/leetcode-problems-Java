public class Leetcode1266 {

    public int minTimeToVisitAllPoints(int[][] points) {

        int res = 0;
        for (int i = 1; i < points.length; i++) {
            int[] pre = points[i - 1];
            int[] cur = points[i];
            int diffX = Math.abs(pre[0] - cur[0]);
            int diffY = Math.abs(pre[1] - cur[1]);
            res += Math.min(diffX, diffY) + Math.abs(diffX - diffY);
        }
        return res;
    }
}
