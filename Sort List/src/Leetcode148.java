import javax.swing.*;

public class Leetcode148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) {this.val = x; this.next = next;}
    }

    // leetcode-21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null? l2: l1;
        return dummy.next;
    }

    public ListNode findMiddleOfList(ListNode head){
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null){
            prev.next = null;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        ListNode midNode = findMiddleOfList(head);
        if(midNode == head) return head;
        ListNode left = sortList(head);
        ListNode right = sortList(midNode);
        return mergeTwoLists(left, right);
    }
}
