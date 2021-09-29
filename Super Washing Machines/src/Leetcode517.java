import java.util.Arrays;

/*
https://leetcode-cn.com/problems/super-washing-machines/solution/csi-lu-by-beny-g/
 */
public class Leetcode517 {

    // consider it as a flow of clothes
    public int findMinMoves(int[] machines) {

        int n = machines.length;
        int total = Arrays.stream(machines).sum();
        if (total % n != 0) {
            return -1;
        }
        int target = total / n;
        int res = 0, sum = 0;
        for (int machine : machines) {
            machine -= target;
            sum += machine;
            res = Math.max(res, Math.max(machine, Math.abs(sum)));
        }
        return res;
    }
}
