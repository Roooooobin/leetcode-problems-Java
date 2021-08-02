import java.util.ArrayList;

public class Leetcode1026 {

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

    class Solution {

        int maxDiff = 0;

        public int maxAncestorDiff(TreeNode root) {

            dfs(root, new ArrayList<>());
            return maxDiff;
        }

        public void dfs(TreeNode node, ArrayList<Integer> ancestors) {

            for (Integer v : ancestors) {
                maxDiff = Math.max(maxDiff, Math.abs(v - node.val));
            }
            ArrayList<Integer> newAncestors = new ArrayList<>(ancestors);
            newAncestors.add(node.val);
            if (node.left != null) {
                dfs(node.left, newAncestors);
            }
            if (node.right != null) {
                dfs(node.right, newAncestors);
            }
        }
    }

    /*
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mn, int mx) {
        if (root == null) return mx - mn;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
    }
     */
}
