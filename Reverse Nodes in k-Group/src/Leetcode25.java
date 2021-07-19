public class Leetcode25 {

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

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; ++i) end = end.next;
            if (end == null) break;
            ListNode groupStart = pre.next;
            ListNode next = end.next;
            end.next = null;
            // 翻转之后groupStart变成了上一组的末尾
            pre.next = reverseLinkedList(groupStart);
            groupStart.next = next;
            pre = groupStart;
            end = pre;
        }
        return dummy.next;
    }

    public ListNode reverseLinkedList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
