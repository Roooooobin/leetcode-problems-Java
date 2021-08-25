public class Jianzhi26 {

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

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean dfs(TreeNode A, TreeNode B) {

        if (A == null && B != null) {
            return false;
        }
        if (B == null) {
            return true;
        }
        if (A.val == B.val) {
            return dfs(A.left, B.left) && dfs(A.right, B.right);
        } else {
            return false;
        }
    }
}
