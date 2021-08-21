import java.util.Arrays;

public class Leetcode1648 {

    public boolean check(int[] nums, int x, int orders) {
        int sum = 0;
        for (int i : nums) {
            sum += Math.max(i - x, 0);
            if (sum > orders) {
                return true;
            }
        }
        return false;
    }

    public int maxProfit(int[] inventory, int orders) {

        final int MOD = 1000000007;
        Arrays.sort(inventory);
        // find l where all (values > l) are sold and some (l) are sold
        int l = 0, r = 1000000000;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(inventory, mid, orders)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        long res = 0;
        for (int x : inventory) {
            if (x > l) {
                int diff = x - l;
                orders -= diff;
                res += ((long) (x + (l + 1)) * (long) diff) >> 1;
                res %= MOD;
            }
        }
        res += (long) orders * (long) l;
        res %= MOD;

        return (int) res;
    }

    //    public int lowerBound(int[] a, int tar) {
    //
    //        int l = 0, r = 1000000000;
    //        while (l < r) {
    //
    //            int mid = l + ((r - l) >> 1);
    //            int cur = 0;
    //            for (int x : a) {
    //                if (x > mid) {
    //                    cur += x - mid;
    //                }
    //            }
    //            if (cur < tar) {
    //                r = mid;
    //            } else {
    //                l = mid + 1;
    //            }
    //        }
    //        return l;
    //    }

    class Solution {
        public boolean ck(int[] nums, int x, int orders) {
            int sum = 0;
            for (int i : nums) {
                sum += Math.max(i - x, 0);
                if (sum > orders) {
                    return true;
                }
            }
            return false;
        }

        public int lowerBound(int[] a, int tar) {

            int l = 0, r = 1000000000;
            while (l <= r) {

                int mid = l + ((r - l) >> 1);
                int cur = 0;
                for (int x : a) {
                    if (x > mid) {
                        cur += x - mid;
                    }
                }
                if (cur == tar) {
                    return mid;
                }
                if (cur < tar) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }

        public int maxProfit(int[] nums, int orders) {
            int l = lowerBound(nums, orders);
            long res = 0, mod = (long) (1e9 + 7);
            for (int i : nums) {
                if (i > l) {
                    res += ((long) (i + l + 1) * (long) (i - l)) >> 1;
                    res %= mod;
                    orders -= i - l;
                }
            }
            res += (long) l * (long) orders;
            res %= mod;
            return (int) res;
        }
    }

    public static void main(String[] args) {
        Leetcode1648 ins = new Leetcode1648();
        System.out.println(ins.maxProfit(new int[] {2, 4, 6, 10, 8}, 4));
    }
}
