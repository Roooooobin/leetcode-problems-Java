import java.util.Arrays;

public class Leetcode1726 {

    public int tupleSameProduct(int[] nums) {

        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; ++i) {
            for (int j = n - 1; j >= i + 3; --j) {
                int mulIJ = nums[i] * nums[j];
                int l = i + 1, r = j - 1;
                while (l < r) {
                    int mulLR = nums[l] * nums[r];
                    if (mulIJ == mulLR) {
                        res += 8;
                        ++l;
                        --r;
                    } else if (mulIJ > mulLR) {
                        ++l;
                    } else {
                        --r;
                    }
                }
            }
        }
        return res;
    }
}
