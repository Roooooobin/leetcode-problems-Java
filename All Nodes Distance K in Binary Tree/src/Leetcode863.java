import java.util.*;

public class Leetcode863 {
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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        HashMap<Integer, ArrayList<Integer>> neighborNodesMap = new HashMap<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pollLast();
            if (top.left != null) {
                stack.offerLast(top.left);
                neighborNodesMap.putIfAbsent(top.val, new ArrayList<>());
                neighborNodesMap.get(top.val).add(top.left.val);
                neighborNodesMap.putIfAbsent(top.left.val, new ArrayList<>());
                neighborNodesMap.get(top.left.val).add(top.val);
            }
            if (top.right != null) {
                stack.offerLast(top.right);
                neighborNodesMap.putIfAbsent(top.val, new ArrayList<>());
                neighborNodesMap.get(top.val).add(top.right.val);
                neighborNodesMap.putIfAbsent(top.right.val, new ArrayList<>());
                neighborNodesMap.get(top.right.val).add(top.val);
            }
        }

        HashMap<Integer, Boolean> visited = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerFirst(target.val);
        visited.put(target.val, true);
        while (k != 0 && !queue.isEmpty()) {
            --k;
            int count = queue.size();
            while (count > 0) {
                --count;
                int top = queue.pollFirst();
                ArrayList<Integer> neighbors =
                        neighborNodesMap.getOrDefault(top, new ArrayList<>());
                for (Integer node : neighbors) {
                    if (visited.containsKey(node)) {
                        continue;
                    }
                    visited.put(node, true);
                    queue.offerLast(node);
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
