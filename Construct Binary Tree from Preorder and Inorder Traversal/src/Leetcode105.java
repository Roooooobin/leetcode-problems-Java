import sun.java2d.windows.GDIWindowSurfaceData;
import sun.reflect.generics.tree.Tree;

public class Leetcode105 {
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

    public TreeNode helper(int[] preorder, int st1, int ed1, int[] inorder, int st2, int ed2) {
        if (st1 >= ed1 || st2 >= ed2) return null;
        int val = preorder[st1];
        int i = st2;
        for (; i<ed2; ++i) {
            if (inorder[i] == val) break;
        }
        int len = i - st2;  // 左子树长度为len
        // i为根的下标，将inorder序列下标i的左右分为左右子树
        TreeNode node = new TreeNode(val);
        node.left = helper(preorder, st1+1, st1+1+len, inorder, st2, i);
        node.right = helper(preorder, st1+1+len, ed1, inorder, i+1, ed2);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
}
