import java.util.LinkedList;
import java.util.List;

public class Leetcode95 {

    public static class TreeNode {
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

    public List<TreeNode> generateTrees(int n) {

        return generate(1, n);
    }

    public List<TreeNode> generate(int l, int r) {

        List<TreeNode> all = new LinkedList<>();
        if (l > r) {
            all.add(null);
            return all;
        }

        for (int i = l; i <= r; i++) {

            List<TreeNode> leftTrees = generate(l, i - 1);
            List<TreeNode> rightTrees = generate(i + 1, r);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftTree;
                    cur.right = rightTree;
                    all.add(cur);
                }
            }
        }
        return all;
    }
}
