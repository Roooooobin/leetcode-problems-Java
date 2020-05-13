import java.util.*;

public class Leetcode102 {
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

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();
            if(root == null) return ans;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            Stack<Integer> stack = new Stack<>();
            while(true) {
                int count = queue.size();
                if(count == 0) break;
                LinkedList<Integer> curLevelNodes = new LinkedList<>();
                while(count > 0) {
                    TreeNode curNode = queue.peek();
                    queue.poll();
                    count--;
                    curLevelNodes.offer(curNode.val);
                    if(curNode.left != null) queue.offer(curNode.left);
                    if(curNode.right != null) queue.offer(curNode.right);
                }
                ans.add(curLevelNodes);
            }
            return ans;
        }
    }
}

