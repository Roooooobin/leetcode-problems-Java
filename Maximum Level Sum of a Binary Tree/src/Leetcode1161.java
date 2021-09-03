import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1161 {

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

    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int res = 1, curLevel = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (true) {
            int count = queue.size();
            if (count == 0) break;
            int curSum = 0;
            while (count > 0) {
                count--;
                TreeNode curNode = queue.pollFirst();
                curSum += curNode.val;
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            if (curSum > max) {
                max = curSum;
                res = curLevel;
            }
            curLevel++;
        }
        return res;
    }
}
