import sun.reflect.generics.tree.Tree;

public class Leetcode98 {

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

public boolean helper(TreeNode node, Integer lower, Integer upper){
    if(node == null) return true;
    int val = node.val;
    if(lower != null && val <= lower) return false;
    if(upper != null && val >= upper) return false;
    if(!helper(node.left, lower, val)) return false;
    if(!helper(node.right, val, upper)) return false;
    return true;
}

public boolean isValidBST(TreeNode root) {
    return root == null || helper(root, null, null);
}

}
