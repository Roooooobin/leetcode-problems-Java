import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode652 {

    HashMap<String, Integer> count;
    List<TreeNode> res;

    // use serialization to help
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        count = new HashMap<>();
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    public String dfs(TreeNode root) {

        if (root == null) {
            return "#";
        }
        String serializationString = root.val + "|" + dfs(root.left) + "|" + dfs(root.right);
        count.put(serializationString, count.getOrDefault(serializationString, 0) + 1);
        if (count.get(serializationString) == 2) {
            res.add(root);
        }
        return serializationString;
    }

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
}
