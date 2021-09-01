import java.util.HashSet;

public class Leetcode565 {

    public int arrayNesting(int[] nums) {

        // num is a permutation so there will not be any intersection
        int res = 1;
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                continue;
            }
            int next = nums[i];
            if (next == i) {
                continue;
            }
            int cur = 0;
            while (!seen.contains(next)) {
                seen.add(next);
                next = nums[next];
                cur++;
            }
            res = Math.max(cur, res);
        }
        return res;
    }

    public static void main(String[] args) {

        //        int[] a = new int[] {5, 4, 0, 3, 1, 6, 2};
        int[] a = new int[] {0, 2, 1};
        Leetcode565 ins = new Leetcode565();
        ins.arrayNesting(a);
    }
}
