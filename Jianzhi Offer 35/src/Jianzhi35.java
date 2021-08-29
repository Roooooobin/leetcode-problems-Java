import java.util.HashMap;

public class Jianzhi35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }
        Node p = head;
        HashMap<Node, Node> hash = new HashMap<>();
        while (p != null) {

            hash.put(p, new Node(p.val));
            p = p.next;
        }

        p = head;
        while (p != null) {

            hash.get(p).next = hash.get(p.next);
            hash.get(p).random = hash.get(p.random);
            p = p.next;
        }
        return hash.get(head);
    }
}
