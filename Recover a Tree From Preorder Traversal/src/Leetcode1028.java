import javafx.util.Pair;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode1028 {
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

    public TreeNode recoverFromPreorder(String S) {
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        int idx = S.indexOf('-');
        if (idx == -1) return new TreeNode(Integer.parseInt(S));
        int rootVal = Integer.parseInt(S.substring(0, idx));
        TreeNode root = new TreeNode(rootVal);
        stack.offerFirst(new Pair<>(root, 0));
        while (!stack.isEmpty()) {
            if (idx >= S.length()) break;
            int level = 0;
            // 通过计算-个数得到当前节点的层数
            while (S.charAt(idx) == '-') {
                ++idx;
                ++level;
            }
            int nextIdx = S.indexOf('-', idx);
            if (nextIdx == -1) nextIdx = S.length();
            int curNodeVal = Integer.parseInt(S.substring(idx, nextIdx));
            idx = nextIdx;
            TreeNode curNode = new TreeNode(curNodeVal);
            // 当前节点层数是栈顶节点层数+1则表示找到了上层的父节点
            while (!stack.isEmpty() && stack.peekFirst().getValue() != level-1) stack.pollFirst();
            TreeNode node = stack.peekFirst().getKey();
            if (node.left == null) {
                node.left = curNode;
            }
            else {
                node.right = curNode;
            }
            stack.offerFirst(new Pair<>(curNode, level));
        }
        return root;
    }

    public static void main(String[] args) {
        String s = "123--1";
        System.out.println(s.indexOf('-'));
    }

    //1-2--3--4-5--6--712
}
