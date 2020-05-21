public class Leetcode82 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy.next;
        ListNode pre = dummy;
        while (p != null && p.next != null) {
            boolean flag = true;
            while (p.next != null && p.val == p.next.val) {
                flag = false;
                p.next = p.next.next;
            }
            if (flag) {
                pre = p;
            }
            else {
                pre.next = p.next;
            }
            p = p.next;
        }
        return dummy.next;
    }
}
