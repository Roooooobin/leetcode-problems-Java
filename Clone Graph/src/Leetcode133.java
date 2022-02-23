import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {

        HashMap<Integer, Node> hash = new HashMap<>();

        public Node cloneGraph(Node root) {

            Node node = new Node(root.val, new ArrayList<>());
            hash.put(node.val, node);
            for (Node neighbor : root.neighbors) {
                if (!hash.containsKey(neighbor.val)) {
                    node.neighbors.add(cloneGraph(neighbor));
                } else {
                    node.neighbors.add(hash.get(neighbor.val));
                }
            }
            return node;
        }
    }
}
