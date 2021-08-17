import java.util.*;

public class Leetcode1654 {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        HashSet<Integer> seen = new HashSet<>();
        seen.add(0);
        for (int v : forbidden) {
            seen.add(v);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[] {0, 0, 0});
        while (!q.isEmpty()) {
            int[] front = q.pollFirst();
            int cur = front[0];
            if (cur == x) {
                return front[2];
            }
            int next;
            if (front[1] == 0) {
                next = cur + a;
                if (next < 6000 && !seen.contains(next)) {
                    q.offerLast(new int[] {next, 0, front[2] + 1});
                    seen.add(next);
                }
                next = cur - b;
                if (next > 0 && !seen.contains(next)) {
                    q.offerLast(new int[] {next, 1, front[2] + 1});
                    //  seen.add(next); 后退到这个点，也可能之后前进到这个点，后退的时候到的不能加入seen
                }
            } else {
                // 不能连续后退两次，只能前进
                next = cur + a;
                if (next < 6000 && !seen.contains(next)) {
                    q.offerLast(new int[] {next, 0, front[2] + 1});
                    seen.add(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Leetcode1654 ins = new Leetcode1654();
        System.out.println(ins.minimumJumps(new int[] {8, 3, 16, 6, 12, 20}, 15, 13, 11));
    }
}
