public class Leetcode725 {

    public ListNode[] splitListToParts(ListNode head, int k) {

        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        int[] numOfEachPartition = new int[k];
        for (int i = 0; i < k; i++) {
            numOfEachPartition[i] = n / k + ((n % k) > i ? 1 : 0);
        }
        ListNode[] res = new ListNode[k];
        p = head;
        for (int i = 0; i < k; i++) {
            if (numOfEachPartition[i] == 0) {
                res[i] = null;
                continue;
            }
            ListNode cur = p;
            ListNode q = cur;
            while (numOfEachPartition[i] > 1) {
                numOfEachPartition[i]--;
                q = q.next;
            }
            p = q.next;
            q.next = null;
            res[i] = cur;
        }
        return res;
    }

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
}
