import java.util.HashMap;
import java.util.Map;

public class Leetcode138 {
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

    private Map<Node, Node> visited = new HashMap<>();

    public Node dfs(Node head) {
        if (head == null) return null;
        if (visited.containsKey(head)) return visited.get(head);
        Node copy = new Node(head.val);
        visited.put(head, copy);
        copy.next = dfs(head.next);
        copy.random = dfs(head.random);
        return copy;
    }

    public Node copyRandomList2(Node head) {
        return dfs(head);
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        HashMap<Node, Node> hash = new HashMap<>();
        Node p = head;
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
