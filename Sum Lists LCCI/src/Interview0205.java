public class Interview0205 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p = l1, q = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (p != null || q != null || carry != 0) {
            int d1 = 0, d2 = 0;
            if (p != null) {
                d1 = p.val;
                p = p.next;
            }
            if (q != null) {
                d2 = q.val;
                q = q.next;
            }
            int sum = d1 + d2 + carry;
            int d;
            if (sum >= 10) {
                carry = 1;
                d = sum - 10;
            } else {
                carry = 0;
                d = sum;
            }
            cur.next = new ListNode(d);
            cur = cur.next;
        }
        return dummy.next;
    }
}
