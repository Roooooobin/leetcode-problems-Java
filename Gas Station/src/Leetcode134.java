public class Leetcode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
        }
        if (sum < 0) {
            return -1;
        }
        int start = 0;
        sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return start != gas.length ? start : 0;
    }
}
