import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Leetcode653 {

    public class TreeNode {
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

    //    public boolean findTarget(TreeNode root, int k) {
    //
    //        return helper(root, root.left, k) || helper(root.left, root, k);
    //    }
    //
    //    public boolean helper(TreeNode node1, TreeNode node2, int k) {
    //
    //        if (node1 == null || node2 == null) {
    //            return false;
    //        }
    //        int sum = node1.val + node2.val;
    //        if (sum < k) {
    //            return helper(node1.right, node2, k) || helper(node1, node2.right, k);
    //        } else if (sum == k) {
    //            return true;
    //        } else {
    //            return helper(node1.left, node2, k) || helper(node1, node2.left, k);
    //        }
    //    }

    ArrayList<Integer> inOrder = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {

        inOrderTraversal(root);
        int l = 0, r = inOrder.size() - 1;
        while (l < r) {
            int lVal = inOrder.get(l), rVal = inOrder.get(r);
            if (lVal + rVal == k) {
                return true;
            } else if (lVal + rVal > k) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    public void inOrderTraversalRecursive(TreeNode node) {

        if (node == null) {
            return;
        }
        inOrderTraversalRecursive(node.left);
        inOrder.add(node.val);
        inOrderTraversalRecursive(node.right);
    }

    public void inOrderTraversal(TreeNode node) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            }
            cur = stack.pollLast();
            inOrder.add(cur.val);
            cur = cur.right;
        }
    }
}
