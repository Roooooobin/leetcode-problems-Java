public class Leetcode495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int res = 0;
        int n = timeSeries.length;
        int i = 0;
        while (i < n - 1) {
            if (timeSeries[i] + duration < timeSeries[i + 1]) {
                res += duration;
            } else {
                res += timeSeries[i + 1] - timeSeries[i];
            }
            i++;
        }
        return res + duration;
    }
}
