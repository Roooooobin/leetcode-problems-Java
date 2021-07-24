public class Leetcode814 {

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

    public TreeNode pruneTree(TreeNode root) {

        if (root.val == 0 && allZero(root.left) && allZero(root.right)) {
            return null;
        }
        doPruneTree(root);
        return root;
    }

    public void doPruneTree(TreeNode root) {

        if (root == null) return;
        boolean left = allZero(root.left), right = allZero(root.right);
        if (left && right) {
            root.left = null;
            root.right = null;
        } else if (right) {
            root.right = null;
            doPruneTree(root.left);
        } else if (left) {
            root.left = null;
            doPruneTree(root.right);
        } else {
            doPruneTree(root.left);
            doPruneTree(root.right);
        }
    }

    public boolean allZero(TreeNode root) {

        if (root == null) return true;
        if (root.val == 1) return false;
        return root.val == 0 && allZero(root.left) && allZero(root.right);
    }

    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            return containsOne(root) ? root : null;
        }

        public boolean containsOne(TreeNode node) {
            if (node == null) return false;
            boolean a1 = containsOne(node.left);
            boolean a2 = containsOne(node.right);
            if (!a1) node.left = null;
            if (!a2) node.right = null;
            return node.val == 1 || a1 || a2;
        }
    }
    /*
    作者：LeetCode
    链接：https://leetcode-cn.com/problems/binary-tree-pruning/solution/er-cha-shu-jian-zhi-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     */
}
