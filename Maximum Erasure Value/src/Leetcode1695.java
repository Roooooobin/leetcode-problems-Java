import java.util.HashMap;

public class Leetcode1695 {

    public int maximumUniqueSubarray(int[] nums) {

        HashMap<Integer, Boolean> visited = new HashMap<>();
        int n = nums.length;
        int l = 0, r = 0;
        visited.put(nums[r], true);
        int maxSum = nums[r++];
        int curSum = maxSum;
        while (r < n) {
            while (r < n && !visited.getOrDefault(nums[r], false)) {
                curSum += nums[r];
                visited.put(nums[r], true);
                ++r;
            }
            maxSum = Math.max(maxSum, curSum);
            if (r == n) break;
            while (nums[l] != nums[r]) {
                curSum -= nums[l];
                visited.put(nums[l], false);
                ++l;
            }
            curSum -= nums[l++];
            curSum += nums[r++];
        }

        return maxSum;
    }
}
