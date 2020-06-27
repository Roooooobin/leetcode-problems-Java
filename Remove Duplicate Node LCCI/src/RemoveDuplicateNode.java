import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        Set<Integer> seen = new HashSet<>();
        seen.add(head.val);
        ListNode p = head;
        while (p.next != null) {
            ListNode cur = p.next;
            if (seen.add(cur.val)) {
                p = p.next;
            }
            else {
                p.next = p.next.next;
            }
        }
        p.next = null;
        return head;
    }
}
