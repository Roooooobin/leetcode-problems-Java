import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1383 {

    class Solution {

        private static final int MOD = 1000000007;

        class Engineer {

            int s;
            int e;

            Engineer(int s, int e) {
                this.s = s;
                this.e = e;
            }
        }

        public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

            ArrayList<Engineer> engineers = new ArrayList<>();
            for (int i = 0; i < speed.length; i++) {
                engineers.add(new Engineer(speed[i], efficiency[i]));
            }
            engineers.sort((o1, o2) -> (o2.e - o1.e));
            PriorityQueue<Engineer> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.s));
            long res = 0, sum = 0;
            for (Engineer engineer : engineers) {
                q.offer(engineer);
                long sumCur = sum + engineer.s;
                res = Math.max(res, sumCur * (long) engineer.e);
                sum += engineer.s;
                if (q.size() == k) {
                    sum -= q.poll().s;
                }
            }
            return (int) (res % MOD);
        }
    }
}
