import java.util.Arrays;

public class Leetcode1094 {

    public boolean carPooling(int[][] trips, int capacity) {

        int n = trips.length;
        Integer[] a = new Integer[n * 2];
        for (int i = 0; i < trips.length; i++) {
            a[2 * i] = i + 1;
            a[2 * i + 1] = -a[2 * i];
        }
        Arrays.sort(
                a,
                (o1, o2) -> {
                    int v1 = parse(o1, trips), v2 = parse(o2, trips);
                    if (v1 == v2) {
                        return o1 - o2;
                    } else {
                        return v1 - v2;
                    }
                });
        //        System.out.println(Arrays.toString(a));

        int cur = 0;
        for (Integer x : a) {

            if (x > 0) {
                cur += trips[x - 1][0];
                if (cur > capacity) {
                    return false;
                }
            } else {
                cur -= trips[-x - 1][0];
            }
        }
        return true;
    }

    public int parse(int x, int[][] trips) {

        int v;
        if (x < 0) {
            v = trips[-x - 1][2];
        } else {
            v = trips[x - 1][1];
        }
        return v;
    }
}
