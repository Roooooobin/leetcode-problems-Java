public class Jianzhi22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode fast = head;
        while (k > 0) {
            k--;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            head = head.next;
        }
        return head;
    }
}
