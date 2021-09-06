import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode1696 {

    public int maxResult(int[] nums, int k) {

        // dp but not for all i, j
        int n = nums.length;
        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        q.offer(new int[] {nums[0], 0});
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            // out of the range
            while (!q.isEmpty() && i - q.peek()[1] > k) {
                q.poll();
            }
            res = q.peek()[0] + nums[i];
            q.offer(new int[] {res, i});
        }
        return res;
    }
}
