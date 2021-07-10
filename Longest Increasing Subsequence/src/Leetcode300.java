public class Leetcode300 {

    public int lengthOfLIS(int[] nums) {

        int len = 0;
        // 保存当前长度的升序串的最小下标
        int[] minIndexOfLen = new int[nums.length + 1];
        minIndexOfLen[len] = nums[0];
        for (int num : nums) {
            if (num > minIndexOfLen[len]) {
                minIndexOfLen[++len] = num;
            } else {
                int idx = lowerBound(minIndexOfLen, 0, len, num);
                minIndexOfLen[idx] = num;
            }
        }

        return len + 1;
    }

    public int lowerBound(int[] nums, int l, int r, int tar) {
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < tar) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        Leetcode300 ins = new Leetcode300();
        int[] nums = new int[] {10, 9, 2, 5, 3, 4};
        System.out.println(ins.lengthOfLIS(nums));

        int[] nums2 = new int[] {1, 2, 3, 4, 5, 6};
        System.out.println(ins.lowerBound(nums2, 0, nums2.length, 2));
    }
}
