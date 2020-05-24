public class Leetcode86 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallerNodes = new ListNode(0);
        ListNode greaterNodes = new ListNode(0);
        ListNode p = smallerNodes;
        ListNode q = greaterNodes;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                head = head.next;
                p = p.next;
                p.next = null;
            }
            else {
                q.next = head;
                head = head.next;
                q = q.next;
                q.next = null;
            }
        }
        p.next = greaterNodes.next;
        return smallerNodes.next;
    }
}
