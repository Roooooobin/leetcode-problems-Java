import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Leetcode1609 {

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

    public boolean isEvenOddTree(TreeNode root) {

        if (root == null) {
            return true;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int curLevelSize = q.size();
            ArrayList<Integer> curNodeValues = new ArrayList<>();
            while (curLevelSize > 0) {
                curLevelSize--;
                TreeNode cur = q.pollFirst();
                if ((level & 1) == 1) {
                    if ((cur.val & 1) == 1) {
                        return false;
                    }
                } else {
                    if ((cur.val & 1) == 0) {
                        return false;
                    }
                }
                curNodeValues.add(cur.val);
                if (cur.left != null) {
                    q.offerLast(cur.left);
                }
                if (cur.right != null) {
                    q.offerLast(cur.right);
                }
            }
            if (!strictlyIncrOrDecr(curNodeValues, (level & 1) == 1)) {
                return false;
            }
            level++;
        }
        return true;
    }

    public boolean strictlyIncrOrDecr(ArrayList<Integer> l, boolean decreased) {

        // even
        if (decreased) {
            for (int i = 0; i < l.size() - 1; i++) {
                if (l.get(i) <= l.get(i + 1)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < l.size() - 1; i++) {
                if (l.get(i) >= l.get(i + 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
