import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public Node copyRandomList(Node head) {
        return dfs(head);
    }
}
