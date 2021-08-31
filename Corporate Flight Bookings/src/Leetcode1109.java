public class Leetcode1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] diff = new int[n + 2];
        for (int[] booking : bookings) {
            diff[booking[0]] += booking[2];
            diff[booking[1] + 1] -= booking[2];
        }
        int[] res = new int[n];
        res[0] = diff[1];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i + 1];
        }
        return res;
    }
}
