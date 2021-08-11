import java.util.*;

public class Leetcode954 {

    // AC
    public boolean canReorderDoubled(int[] arr) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int x : arr) {
            hash.put(x, hash.getOrDefault(x, 0) + 1);
        }
        // 可以用绝对值排序，避免重复处理负数和正数
        Arrays.sort(arr);
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                break;
            }
        }
        // 负数
        for (int j = i - 1; j >= 0; j--) {
            int x = arr[j];
            if (seen.getOrDefault(x, 0) > 0) {
                seen.put(x, seen.get(x) - 1);
            } else {
                int y = 2 * x;
                if (hash.getOrDefault(y, 0) <= 0) {
                    return false;
                }
                seen.put(y, seen.getOrDefault(y, 0) + 1);
                hash.put(y, hash.getOrDefault(y, 0) - 1);
            }
        }
        // 正数
        for (int j = i; j < arr.length; j++) {
            int x = arr[j];
            if (seen.getOrDefault(x, 0) > 0) {
                seen.put(x, seen.get(x) - 1);
            } else {
                int y = 2 * x;
                if (hash.getOrDefault(y, 0) <= 0) {
                    return false;
                }
                seen.put(y, seen.getOrDefault(y, 0) + 1);
                hash.put(y, hash.getOrDefault(y, 0) - 1);
            }
        }

        return true;
    }

    class Solution {
        public boolean canReorderDoubled(int[] A) {
            // count[x] = the number of occurrences of x in A
            Map<Integer, Integer> count = new HashMap();
            for (int x : A) count.put(x, count.getOrDefault(x, 0) + 1);

            // B = A as Integer[], sorted by absolute value
            Integer[] B = new Integer[A.length];
            for (int i = 0; i < A.length; ++i) B[i] = A[i];
            Arrays.sort(B, Comparator.comparingInt(Math::abs));

            for (int x : B) {
                // If this can't be consumed, skip
                if (count.get(x) == 0) continue;
                // If this doesn't have a doubled partner, the answer is false
                if (count.getOrDefault(2 * x, 0) <= 0) return false;

                // Write x, 2*x
                count.put(x, count.get(x) - 1);
                count.put(2 * x, count.get(2 * x) - 1);
            }

            // If we have written everything, the answer is true
            return true;
        }
    }

    /*
    作者：LeetCode
    链接：https://leetcode-cn.com/problems/array-of-doubled-pairs/solution/er-bei-shu-dui-shu-zu-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    */

    public static void main(String[] args) {

        //        int[] arr = new int[] {2, 1, 2, 1, 1, 1, 2, 2};
        int[] arr = new int[] {-4, -6, -1, -2, -1, -1, -3, -8};
        Leetcode954 ins = new Leetcode954();
        System.out.println(ins.canReorderDoubled(arr));
    }
}
