public class Leetcode23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode dummy = cur;
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

//    public ListNode mergeKLists(ListNode[] lists) {
//        if(lists.length == 0) return null;
//        ListNode res = lists[0];
//        for(int i=1; i<lists.length; ++i){
//            res = mergeTwoLists(res, lists[i]);
//        }
//        return res;
//    }

    // divide and conquer
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        int interval = 1;
        while(interval < n){
            for(int i=0; i<n-interval; i+=interval*2){
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
}
