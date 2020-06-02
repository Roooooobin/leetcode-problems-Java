import sun.reflect.generics.tree.Tree;

public class Leetcode124 {
    public static class TreeNode {
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

    private int maxSum = Integer.MIN_VALUE;

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(0, helper(root.left));
        int rightSum = Math.max(0, helper(root.right));
        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);
        return root.val + Math.max(leftSum, rightSum);
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public static void main(String[] args) {
        Leetcode124 leetcode124 = new Leetcode124();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.left = node1;
        TreeNode node2 = new TreeNode(3);
        root.right = node2;
        System.out.println(leetcode124.maxPathSum(root));
    }
}
