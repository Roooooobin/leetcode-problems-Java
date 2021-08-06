import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(Node root) {

            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<Node> q = new ArrayDeque<>();
            q.offerLast(root);
            while (!q.isEmpty()) {
                int count = q.size();
                ArrayList<Integer> nodesCurLevel = new ArrayList<>();
                while (count > 0) {
                    --count;
                    Node frontNode = q.pollFirst();
                    nodesCurLevel.add(frontNode.val);
                    for (Node child : frontNode.children) {
                        q.offerLast(child);
                    }
                }
                res.add(nodesCurLevel);
            }
            return res;
        }
    }
}
