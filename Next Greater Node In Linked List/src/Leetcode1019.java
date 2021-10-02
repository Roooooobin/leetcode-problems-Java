import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1019 {

    public int[] nextLargerNodes(ListNode head) {

        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        int[] res = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        p = head;
        int i = 0;
        while (p != null) {
            while (!stack.isEmpty() && stack.peekLast()[0] < p.val) {
                res[stack.pollLast()[1]] = p.val;
            }
            stack.offerLast(new int[] {p.val, i++});
            p = p.next;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
