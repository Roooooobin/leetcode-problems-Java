import java.util.ArrayList;
import java.util.Comparator;

public class Leetcode1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        ArrayList<int[]> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new int[] {startTime[i], endTime[i], profit[i]});
        }
        a.sort((Comparator.comparingInt(o -> o[1])));

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int l = -1, r = i - 1;
            while (l < r) {
                int mid = l + ((r - l + 1) >> 1);
                if (a.get(mid)[1] <= a.get(i)[0]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            dp[i + 1] = Math.max(dp[i], dp[l + 1] + a.get(i)[2]);
        }
        return dp[n];
    }
}
