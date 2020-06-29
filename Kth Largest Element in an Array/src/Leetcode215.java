public class Leetcode215 {
    public int partition(int[] nums, int l, int r) {
        int i = l, j = r;
        int tmp = nums[i];
        nums[i] = nums[i+(j-i)/2];
        nums[i+(j-i)/2] = tmp;
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) --j;
            if (i < j) nums[i++] = nums[j];
            while (i < j && nums[i] <= pivot) ++i;
            if (i < j) nums[j--] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int l = 0, r = n - 1;
        while (true) {
            int i = partition(nums, l, r);
            if (i == k) {
                return nums[i];
            }
            else if (i < k) {
                l = i + 1;
            }
            else r = i - 1;
        }
    }
}
