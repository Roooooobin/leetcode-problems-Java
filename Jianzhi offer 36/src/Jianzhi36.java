import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Jianzhi36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    ;

    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Node p = root;
        ArrayList<Node> nodes = new ArrayList<>();
        while (p != null || !stack.isEmpty()) {

            while (p != null) {
                stack.offerLast(p);
                p = p.left;
            }
            p = stack.pollLast();
            nodes.add(p);
            p = p.right;
        }
        int n = nodes.size();
        nodes.get(0).left = nodes.get(n - 1);
        nodes.get(n - 1).right = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            Node nodeL = nodes.get(i - 1);
            Node nodeR = nodes.get(i);
            nodeL.right = nodeR;
            nodeR.left = nodeL;
        }
        return nodes.get(0);
    }
}
