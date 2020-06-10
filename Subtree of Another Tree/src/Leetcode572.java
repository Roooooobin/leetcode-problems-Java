public class Leetcode572 {
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

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String sPreorder = preorder(s, true);
        String tPreorder = preorder(t, true);
        return sPreorder.contains(tPreorder);
    }

    public String preorder(TreeNode node, boolean isLeft) {
        if (node == null) {
            if (isLeft) {
                return "lnull";
            }
            else {
                return "rlull";
            }
        }
        return "#" + node.val + preorder(node.left, true) + preorder(node.right, false);
    }
}
