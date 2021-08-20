public class Jianzhi18 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy.next;
        ListNode pre = dummy;
        while (p != null && p.val != val) {
            pre = p;
            p = p.next;
        }
        if (p != null) {
            pre.next = p.next;
        }
        return dummy.next;
    }
}
