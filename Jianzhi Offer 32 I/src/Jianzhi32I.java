import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Jianzhi32I {

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

    public int[] levelOrder(TreeNode root) {

        ArrayList<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            nodes.add(node.val);
            if (node.left != null) {
                q.offerLast(node.left);
            }
            if (node.right != null) {
                q.offerLast(node.right);
            }
        }
        int[] res = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            res[i] = nodes.get(i);
        }
        return res;
    }
}
