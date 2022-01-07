import java.util.Random;

public class Leetcode382 {

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

    //    class Solution {
    //
    //        int n = 0;
    //        ArrayList<Integer> val = new ArrayList<>();
    //        Random random = new Random();
    //
    //        public Solution(ListNode head) {
    //            ListNode p = head;
    //            while (p != null) {
    //                val.add(p.val);
    //                p = p.next;
    //                n++;
    //            }
    //        }
    //
    //        public int getRandom() {
    //            int idx = random.nextInt(n);
    //            return val.get(idx);
    //        }
    //    }

    // 蓄水池抽样
    class Solution {

        ListNode head;
        Random random;

        public Solution(ListNode head_) {
            head = head_;
            random = new Random();
        }

        public int getRandom() {
            int n = 0;
            // 1/n 保留当前 (n-1)/n保留之前
            int reserved = 0;
            ListNode p = head;
            while (p != null) {
                n++;
                int randInt = random.nextInt(n);
                if (randInt == 0) {
                    reserved = p.val;
                }
                p = p.next;
            }
            return reserved;
        }
    }
}
