public class Leetcode1300 {
    public static int findBestValue(int[] arr, int target) {
        int l = 0, r = Integer.MIN_VALUE;
        for (int x : arr) {
            r = Math.max(r, x);
        }
        int minDiff = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
//            System.out.println(mid);
            int curSum = 0;
            for (int x : arr) {
                curSum += Math.min(x, mid);
            }
            int curDiff = Math.abs(curSum - target);
            if (curDiff <= minDiff) {
                if (curDiff == minDiff) ans = Math.min(ans, mid);
                else ans = mid;
                minDiff = curDiff;
            }
            if (curSum < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803));
        System.out.println(findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(findBestValue(new int[]{2, 5, 3}, 11));
    }
}
