import java.util.*;

public class Leetcode94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !treeNodeStack.isEmpty()) {
            while (cur != null) {
                treeNodeStack.push(cur);
                cur = cur.left;
            }
            cur = treeNodeStack.pop();
            inorder.add(cur.val);
            cur = cur.right;
        }
        return inorder;
    }
}
