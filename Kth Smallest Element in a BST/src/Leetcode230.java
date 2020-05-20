import java.util.Stack;

public class Leetcode230 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();
        while (true) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            root = nodes.pop();
            --k;
            if (k == 0) return root.val;
            else root = root.right;
        }
    }
}
