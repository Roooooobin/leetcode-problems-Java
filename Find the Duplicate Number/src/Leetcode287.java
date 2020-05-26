public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        // 首先找到快慢指针在环内的交点
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // 再找环的入口，即答案
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
