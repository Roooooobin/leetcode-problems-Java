import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode671 {
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

    public int findSecondMinimumValue(TreeNode root) {

        int min = root.val, secondMin = Integer.MAX_VALUE;
        boolean flag = false;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pollLast();
            if (top.val < min) {
                min = top.val;
                secondMin = min;
                flag = true;
            } else if (top.val > min && top.val <= secondMin) {
                secondMin = top.val;
                flag = true;
            }
            if (top.left != null) {
                stack.offerLast(top.left);
            }
            if (top.right != null) {
                stack.offerLast(top.right);
            }
        }
        return flag ? secondMin : -1;
    }
}
