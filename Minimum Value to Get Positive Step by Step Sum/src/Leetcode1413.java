public class Leetcode1413 {

    public int minStartValue(int[] nums) {

        int n = nums.length;
        int l = 1, r = n * 100 + 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int sum = mid;
            boolean flag = true;
            for (int x : nums) {
                sum += x;
                if (sum < 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
