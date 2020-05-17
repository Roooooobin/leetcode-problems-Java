public class Leetcode61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        int len = 1;
        while (p.next != null) {
            ++len;
            p = p.next;
        }
        k %= len;
        if (k == 0) return head;
        ListNode tail = p;
        p = head;
        k = len - k;
        while (k > 1) {
            --k;
            p = p.next;
        }
        dummy.next = p.next;
        p.next = null;
        tail.next = head;
        return dummy.next;
    }
}
