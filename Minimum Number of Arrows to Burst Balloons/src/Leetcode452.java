import java.util.Arrays;
import java.util.Comparator;

public class Leetcode452 {

    // AC
    //    class Solution {
    //        public int findMinArrowShots(int[][] points) {
    //
    //            Arrays.sort(
    //                    points,
    //                    (o1, o2) -> {
    //                        if (o1[0] == o2[0]) {
    //                            return Integer.compare(o1[1], o2[1]);
    //                        } else {
    //                            return Integer.compare(o1[0], o2[0]);
    //                        }
    //                    });
    //            int res = 0;
    //            int i = 0;
    //            int n = points.length;
    //            while (i < n) {
    //                int curEnd = points[i][1];
    //                res++;
    //                int j = i + 1;
    //                while (j < n && points[j][0] <= curEnd) {
    //                    curEnd = Math.min(curEnd, points[j][1]);
    //                    j++;
    //                }
    //                i = j;
    //            }
    //            return res;
    //        }
    //    }

    // better one
    class Solution {
        public int findMinArrowShots(int[][] points) {

            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
            int res = 1;
            int curEnd = points[0][1];
            for (int[] point : points) {
                if (point[0] > curEnd) {
                    curEnd = point[1];
                    res++;
                }
            }
            return res;
        }
    }
}
