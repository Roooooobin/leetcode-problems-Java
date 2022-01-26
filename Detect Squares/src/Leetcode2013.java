import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Leetcode2013 {

    class DetectSquares {

        final int BASE = 1003;
        HashMap<Integer, Integer> points;
        HashMap<Integer, ArrayList<Integer>> pointsOnRow;

        public DetectSquares() {

            points = new HashMap<>();
            pointsOnRow = new HashMap<>();
        }

        public void add(int[] point) {

            int v = point[0] * BASE + point[1];
            points.put(v, points.getOrDefault(v, 0) + 1);
            ArrayList<Integer> l = pointsOnRow.getOrDefault(point[1], new ArrayList<>());
            l.add(v);
            pointsOnRow.put(point[1], l);
        }

        public int count(int[] point) {

            int res = 0;
            int cur = point[0] * BASE + point[1];
            //            System.out.println(points);
            //            System.out.println(pointsOnRow);
            // 枚举同一行的所有点，然后找同一垂直线的点，再找对角线
            HashSet<Integer> seen = new HashSet<>();
            for (int v : pointsOnRow.getOrDefault(point[1], new ArrayList<>())) {
                if (v == cur || seen.contains(v)) {
                    continue;
                }
                seen.add(v);
                int x = v / BASE;
                // upper
                int upper = point[0] * BASE + point[1] + Math.abs(x - point[0]);
                int diag = x * BASE + point[1] + Math.abs(x - point[0]);
                if (points.containsKey(upper) && points.containsKey(diag)) {
                    res += points.get(v) * points.get(upper) * points.get(diag);
                }

                // lower
                int lower = point[0] * BASE + point[1] - Math.abs(x - point[0]);
                int diag2 = x * BASE + point[1] - Math.abs(x - point[0]);
                if (points.containsKey(lower) && points.containsKey(diag2)) {
                    res += points.get(v) * points.get(lower) * points.get(diag2);
                }
            }
            return res;
        }
    }
}
