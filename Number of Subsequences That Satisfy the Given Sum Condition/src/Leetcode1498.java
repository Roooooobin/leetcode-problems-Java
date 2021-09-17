import java.util.Arrays;

public class Leetcode1498 {

    final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {

        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = 0;
        while (i <= j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else {
                res += pow(2, j - i);
                res %= MOD;
                i++;
            }
        }
        return res;
    }

    public int pow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
                res %= MOD;
            }
            x *= x;
            x %= MOD;
            n >>= 1;
        }
        return (int) res;
    }

    /*
        public double quickPowIterative(double x, long n){
        double ans = 1.0;
        while(n > 0){
            if(n % 2 == 1){
                ans *= x;
            }
            x *= x;
            n /= 2;
        }
        return ans;
    }
     */
}
