import java.util.HashMap;

public class Leetcode447 {

    public int numberOfBoomerangs(int[][] points) {

        int res = 0;
        for (int[] p1 : points) {
            HashMap<Integer, Integer> disCountMap = new HashMap<>();
            for (int[] p2 : points) {
                int dis = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                int count = disCountMap.getOrDefault(dis, 0);
                res += count * 2;
                disCountMap.put(dis, count + 1);
            }
        }
        return res;
    }
}
