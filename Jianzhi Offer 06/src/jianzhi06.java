import java.util.ArrayDeque;
import java.util.Deque;

public class jianzhi06 {

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

    public int[] reversePrint(ListNode head) {

        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.offerLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pollLast();
        }
        return res;
    }
}
