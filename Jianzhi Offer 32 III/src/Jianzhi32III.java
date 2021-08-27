import java.util.*;

public class Jianzhi32III {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> nodes = new ArrayList<>();
            while (size > 0) {
                size--;
                TreeNode node = q.pollFirst();
                nodes.add(node.val);
                if (node.left != null) {
                    q.offerLast(node.left);
                }
                if (node.right != null) {
                    q.offerLast(node.right);
                }
            }
            res.add(nodes);
        }
        for (int i = 0; i < res.size(); i++) {
            if ((i & 1) == 1) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }
}
