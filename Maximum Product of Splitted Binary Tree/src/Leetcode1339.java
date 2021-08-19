import java.util.HashMap;

public class Leetcode1339 {

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

    private static final int MOD = 1000000007;
    private long totalSum;
    private long maxProduct;
    HashMap<TreeNode, Long> node2Product;

    public int maxProduct(TreeNode root) {

        totalSum = 0;
        maxProduct = 0;
        node2Product = new HashMap<>();
        calcWholeTreeSum(root);
        calcMaxProduct(root);
        return (int) (maxProduct % MOD);
    }

    public void calcWholeTreeSum(TreeNode node) {

        if (node == null) {
            return;
        }
        totalSum += node.val;
        calcWholeTreeSum(node.left);
        calcWholeTreeSum(node.right);
    }

    public long calcSubTreeSum(TreeNode node) {

        if (node == null) {
            return 0;
        }
        if (node2Product.containsKey(node)) {
            return node2Product.get(node);
        }
        long sum = node.val;
        if (node2Product.containsKey(node.left)) {
            sum += node2Product.get(node.left);
        } else {
            sum += calcSubTreeSum(node.left);
        }
        if (node2Product.containsKey(node.right)) {
            sum += node2Product.get(node.right);
        } else {
            sum += calcSubTreeSum(node.right);
        }
        node2Product.put(node, sum);
        return sum;
    }

    public void calcMaxProduct(TreeNode node) {

        if (node == null) {
            return;
        }
        long leftSum = calcSubTreeSum(node.left);
        long rightSum = calcSubTreeSum(node.right);
        maxProduct =
                Math.max(
                        Math.max(leftSum * (totalSum - leftSum), rightSum * (totalSum - rightSum)),
                        maxProduct);
        calcMaxProduct(node.left);
        calcMaxProduct(node.right);
    }
}
