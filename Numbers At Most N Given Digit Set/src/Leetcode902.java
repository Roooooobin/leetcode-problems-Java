public class Leetcode902 {

    // TLE
    //    int res = 0;
    //
    //    public int atMostNGivenDigitSet(String[] digits, int n) {
    //
    //        int x = 10;
    //        int cnt = digits.length;
    //        // first find all numbers in digits [0, digit(n) - 1]
    //        int count = 1;
    //        int nDigit = 1;
    //        while (x < n) {
    //            count *= cnt;
    //            res += count;
    //            x *= 10;
    //            nDigit++;
    //        }
    //        // find all possible numbers in digit (digit(n))
    //        backtracking(digits, "", n, 0, nDigit);
    //        return res;
    //    }
    //
    //    public void backtracking(String[] digits, String cur, int tar, int idx, int tarIdx) {
    //
    //        if (idx == tarIdx) {
    //            int curVal = Integer.parseInt(cur);
    //            if (curVal <= tar) {
    //                res++;
    //                return;
    //            }
    //        } else if (idx > tarIdx) {
    //            return;
    //        }
    //        for (String digit : digits) {
    //            backtracking(digits, cur + digit, tar, idx + 1, tarIdx);
    //        }
    //    }

    /*
    https://leetcode-cn.com/problems/numbers-at-most-n-given-digit-set/solution/zui-da-wei-n-de-shu-zi-zu-he-by-leetcode/
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {

        // dp[i] 表示小于等于N中最后|N| - i位的合法数的个数
        // N = 2345, dp[0], dp[1], dp[2], dp[3] 分别表示小于等于 2345, 345, 45, 5 的合法数的个数
        String s = String.valueOf(n);
        int k = s.length();
        int[] dp = new int[k + 1];
        dp[k] = 1;
        // k位的合法数
        for (int i = k - 1; i >= 0; i--) {
            int x = s.charAt(i) - '0';
            for (String digit : digits) {
                int di = Integer.parseInt(digit);
                if (di < x) {
                    dp[i] += Math.pow(digits.length, k - i - 1);
                } else if (di == x) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        // 加上所有k位以下的合法数
        for (int i = 1; i < k; i++) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }
}
