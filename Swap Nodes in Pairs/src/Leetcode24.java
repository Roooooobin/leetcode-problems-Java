public class Leetcode24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode first, second;
        while(cur.next != null && cur.next.next != null){
            first = cur.next;
            second = cur.next.next;
            cur.next = second;
            first.next = second.next;
            second.next = first;
            cur = first;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
