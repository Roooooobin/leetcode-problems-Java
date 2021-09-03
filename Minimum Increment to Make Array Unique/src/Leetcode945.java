import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Leetcode945 {

    public int minIncrementForUnique(int[] nums) {

        ArrayList<Integer> dup = new ArrayList<>();
        HashSet<Integer> exist = new HashSet<>();
        for (int num : nums) {
            if (exist.contains(num)) {
                dup.add(num);
            } else {
                exist.add(num);
            }
        }
        Collections.sort(dup);
        int res = 0;
        int cur = 0;
        for (Integer x : dup) {
            cur = Math.max(cur, x) + 1;
            while (exist.contains(cur)) {
                cur++;
            }
            res += cur - x;
        }
        return res;
    }
}

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, taken = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] == nums[i]) {
                taken++;
                ans -= nums[i];
            } else {
                int give = Math.min(taken, nums[i] - nums[i - 1] - 1);
                ans += give * (give + 1) / 2 + give * nums[i - 1];
                taken -= give;
            }
        }

        if (nums.length > 0) {
            ans += taken * (taken + 1) / 2 + taken * nums[nums.length - 1];
        }

        return ans;
    }
}
/*
       作者：LeetCode-Solution
       链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/solution/shi-shu-zu-wei-yi-de-zui-xiao-zeng-liang-by-leet-2/
       来源：力扣（LeetCode）
       著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/
/*
def minIncrementForUnique(self, A):
    A.sort()
    res = 0
    for i in range(1,len(A)):
        if A[i] <= A[i-1]:
            res += A[i-1]-A[i]+1
            A[i] = A[i-1]+1
    return res
 */
