public class Leetcode19 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode p = dummy;
        for(int i=0; i<n+1; ++i){
            fast = fast.next;
        }
        while(fast != null){
            p = p.next;
            fast = fast.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Leetcode19 instance = new Leetcode19();

    }
}

