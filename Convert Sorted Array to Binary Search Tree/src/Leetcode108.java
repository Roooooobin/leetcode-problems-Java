public class Leetcode108 {

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

    public TreeNode sortedArrayToBST(int[] nums) {

        return doConvert(nums, 0, nums.length - 1);
    }

    public TreeNode doConvert(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }
        int mid = l + ((r - l) >> 1);
        TreeNode head = new TreeNode(nums[mid]);
        head.left = doConvert(nums, l, mid - 1);
        head.right = doConvert(nums, mid + 1, r);
        return head;
    }
}
