public class Leetcode430 {

    public Node flatten(Node head) {

        Node p = head;
        while (p != null) {
            while (p != null && p.child == null) {
                p = p.next;
            }
            if (p == null) {
                break;
            }
            Node next = p.next;
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
            Node lastOfChild = dfs(p.next);
            lastOfChild.next = next;
            if (next == null) {
                break;
            }
            next.prev = lastOfChild;
            p = next;
        }

        return head;
    }

    public Node dfs(Node node) {

        Node p = node;
        Node pre = p;
        while (p != null && p.child == null) {
            pre = p;
            p = p.next;
        }
        if (p == null) {
            return pre;
        } else {
            Node next = p.next;
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
            Node lastOfChild = dfs(p.next);
            lastOfChild.next = next;
            if (next != null) {
                next.prev = lastOfChild;
                return dfs(next);
            }
            return lastOfChild;
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
