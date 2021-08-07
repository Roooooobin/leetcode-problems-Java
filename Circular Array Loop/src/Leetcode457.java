public class Leetcode457 {

    static class Solution {

        private static final int ADD = 1000;
        private static final int UPPER = 1000;
        private static final int LOWER = -1000;

        public boolean circularArrayLoop(int[] nums) {

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > UPPER || nums[i] < LOWER) {
                    continue;
                }
                if (findCircle(nums, i)) {
                    return true;
                }
            }
            return false;
        }

        public boolean findCircle(int[] a, int start) {
            // 快慢指针找环

            int flag = a[start] > 0 ? 1 : -1;
            int n = a.length;
            int slow = start, fast = start;
            do {
                int stepSlow = a[slow];
                if (stepSlow > UPPER) {
                    stepSlow -= ADD;
                } else if (stepSlow < LOWER) {
                    stepSlow += ADD;
                } else {
                    a[slow] += flag * ADD;
                }
                int next = (slow + stepSlow + n) % n;
                if (next < 0) {
                    next += n;
                }
                if (flag * a[next] < 0) {
                    return false;
                }
                if (next == slow) {
                    return false;
                }
                slow = next;

                int stepFast = a[fast];
                if (stepFast > UPPER) {
                    stepFast -= ADD;
                } else if (stepFast < LOWER) {
                    stepFast += ADD;
                } else {
                    a[fast] += flag * ADD;
                }
                int fastNext = (fast + stepFast + n) % n;
                if (fastNext < 0) {
                    fastNext += n;
                }
                if (fastNext == fast) {
                    return false;
                }
                if (flag * a[fastNext] < 0) {
                    return false;
                }
                int stepNext = a[fastNext];
                if (stepNext > UPPER) {
                    stepNext -= ADD;
                } else if (stepNext < LOWER) {
                    stepNext += ADD;
                } else {
                    a[fastNext] += flag * ADD;
                }
                int fastNextNext = (fastNext + stepNext + n) % n;
                if (fastNextNext < 0) {
                    fastNextNext += n;
                }
                if (fastNextNext == fastNext) {
                    return false;
                }
                if (flag * a[fastNextNext] < 0) {
                    return false;
                }
                fast = fastNextNext;

            } while (slow != fast);
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, -1, 1, 2, 2};
        Solution ins = new Solution();
        ins.findCircle(nums, 0);
    }
}
