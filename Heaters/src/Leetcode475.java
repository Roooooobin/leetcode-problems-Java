import java.util.Arrays;

public class Leetcode475 {

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int n = houses.length;
        int lo = 0, hi = 0x3f3f3f3f;
        while (lo <= hi) {
            int r = lo + ((hi - lo) >> 1);
            if (checkRadius(houses, heaters, r)) {
                hi = r - 1;
            } else {
                lo = r + 1;
            }
        }
        return lo;
    }

    public boolean checkRadius(int[] houses, int[] heaters, int r) {

        int n = houses.length;
        int i = 0; // idx of houses
        for (int heater : heaters) {
            int lo = heater - r, hi = heater + r;
            while (i < n) {
                if (houses[i] >= lo && houses[i] <= hi) {
                    i++;
                } else {
                    break;
                }
            }
        }
        return i >= n;
    }

    public static void main(String[] args) {
        Leetcode475 ins = new Leetcode475();
        int r = ins.findRadius(new int[] {1, 5}, new int[] {2});
        System.out.println(r);
    }
}
