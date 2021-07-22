import java.util.PriorityQueue;

public class Leetcode915 {

    public int partitionDisjoint(int[] nums) {

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        left.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            right.add(nums[i]);
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            int leftMax = left.peek();
            int rightMin = right.peek();
            if (leftMax <= rightMin) {
                res = i;
                break;
            }
            left.add(nums[i]);
            right.remove(nums[i]);
        }
        return res;
    }

    /*
    https://leetcode.com/problems/partition-array-into-disjoint-intervals/discuss/175945/Java-one-pass-7-lines
        */
    public int partitionDisjoint2(int[] nums) {

        int partitionLeftMax = nums[0];
        int partitionIdx = 0;
        int maxUntilI = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (partitionLeftMax > nums[i]) {
                partitionIdx = i;
                partitionLeftMax = maxUntilI;
            } else {
                maxUntilI = Math.max(maxUntilI, nums[i]);
            }
        }
        return partitionIdx + 1;
    }
}
