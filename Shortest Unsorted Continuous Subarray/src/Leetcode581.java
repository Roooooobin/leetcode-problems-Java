import java.util.Arrays;

public class Leetcode581 {

    // O(nlogn)
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        int[] numsSorted = new int[n];
        System.arraycopy(nums, 0, numsSorted, 0, n);
        Arrays.sort(numsSorted);
        int l = 0, r = n - 1;
        while (l < n && nums[l] == numsSorted[l]) {
            ++l;
        }
        if (l == n) {
            return 0;
        }
        while (nums[r] == numsSorted[r]) {
            --r;
        }
        return r - l + 1;
    }

    // O(n)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int max = Integer.MIN_VALUE, r = -1;
            int min = Integer.MAX_VALUE, l = -1;
            for (int i = 0; i < n; i++) {
                if (max > nums[i]) {
                    r = i;
                } else {
                    max = nums[i];
                }
                if (min < nums[n - i - 1]) {
                    l = n - i - 1;
                } else {
                    min = nums[n - i - 1];
                }
            }
            return r == -1 ? 0 : r - l + 1;
        }
    }
}
