public class Leetcode1448 {

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

    int res = 0;

    public int goodNodes(TreeNode root) {

        countGoodNodes(root, root.val);
        return res;
    }

    public void countGoodNodes(TreeNode root, int max) {

        if (root.val >= max) {
            res++;
            max = root.val;
        }
        if (root.left != null) {
            countGoodNodes(root.left, max);
        }
        if (root.right != null) {
            countGoodNodes(root.right, max);
        }
    }
}
