import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode1305 {

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

        ArrayList<Integer> res = new ArrayList<>();

        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

            dfs(root1);
            dfs(root2);
            Collections.sort(res);
            return res;
        }

        public void dfs(TreeNode root) {

            if (root == null) {
                return;
            }
            res.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
}
