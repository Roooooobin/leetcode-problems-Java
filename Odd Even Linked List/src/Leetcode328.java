public class Leetcode328 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) return head;
            int count = 3;
            ListNode evenList = head.next;
            ListNode p = head.next.next;
            ListNode odd = head, even = evenList;
            while (p != null) {
                if (count % 2 == 1) {
                    odd.next = p;
                    odd = odd.next;
                }
                else {
                    even.next = p;
                    even = even.next;
                }
                p = p.next;
                ++count;
            }
            odd.next = evenList;
            even.next = null;
            return head;
        }
    }

    // more concise
    public class Solution2 {
        public ListNode oddEvenList(ListNode head) {
            if (head == null) return null;
            ListNode odd = head, even = head.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }
}
