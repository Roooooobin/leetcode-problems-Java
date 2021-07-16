public class Leetcodejianzhi53 {

    public int search(int[] nums, int target) {

        int n = nums.length;
        return upperBound(nums, 0, n - 1, target) - lowerBound(nums, 0, n - 1, target);
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
