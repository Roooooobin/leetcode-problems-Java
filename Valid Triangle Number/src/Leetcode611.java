import java.util.Arrays;

public class Leetcode611 {

    public int triangleNumber(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int idxLowerBound = lowerBound(nums, j + 1, n - 1, nums[j]);
                int idxUpperBound = upperBound(nums, j + 1, n - 1, nums[i] + nums[j] - 1);
                res += idxUpperBound - idxLowerBound;
            }
        }

        return res;
    }

    public int lowerBound(int[] nums, int l, int r, int tar) {

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int upperBound(int[] nums, int l, int r, int tar) {

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] <= tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
