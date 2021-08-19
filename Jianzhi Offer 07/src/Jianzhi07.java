public class Jianzhi07 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        return doBuildTree(preorder, inorder, 0, n, 0, n);
    }

    public TreeNode doBuildTree(
            int[] preorder, int[] inorder, int lPre, int rPre, int lIn, int rIn) {

        if (lPre >= rPre || lIn >= rIn) {
            return null;
        }
        TreeNode node = new TreeNode();
        int val = preorder[lPre];
        node.val = val;
        int i;
        for (i = lIn; i < rIn; i++) {
            if (inorder[i] == val) {
                break;
            }
        }
        node.left = doBuildTree(preorder, inorder, lPre + 1, lPre + i - lIn + 1, lIn, i);
        node.right = doBuildTree(preorder, inorder, lPre + i - lIn + 1, rPre, i + 1, rIn);
        return node;
    }

    public static void main(String[] args) {

        Jianzhi07 ins = new Jianzhi07();
        ins.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
    }
}
