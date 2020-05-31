import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
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

    public void dfs(TreeNode node, int sum, List<List<Integer>> ans, ArrayList<Integer> curList) {
        if (node == null) return;
        curList.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            ans.add(new ArrayList<>(curList));
            curList.remove(curList.size() - 1);
            return;
        }
        dfs(node.left, sum - node.val, ans, curList);
        dfs(node.right, sum - node.val, ans, curList);
        curList.remove(curList.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, sum, ans, new ArrayList<>());
        return ans;
    }
}
