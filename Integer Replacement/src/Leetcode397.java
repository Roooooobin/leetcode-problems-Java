import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Leetcode397 {

    public int integerReplacement(int n) {

        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[] {n, 0});
        HashSet<Integer> seen = new HashSet<>();
        seen.add(n);
        while (!q.isEmpty()) {
            int[] front = q.pollFirst();
            int val = front[0];
            if (val == 1) {
                return front[1];
            }
            int next;
            if ((val & 1) == 1) {
                next = val + 1;
                if (!seen.contains(next)) {
                    q.offerLast(new int[] {next, front[1] + 1});
                    seen.add(next);
                }
                next = val - 1;
            } else {
                next = val >> 1;
            }
            if (!seen.contains(next)) {
                q.offerLast(new int[] {next, front[1] + 1});
                seen.add(next);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode397 ins = new Leetcode397();
        System.out.println(ins.integerReplacement(Integer.MAX_VALUE));
    }
}
