import java.util.TreeMap;

public class Leetcode1296 {

    class Solution {

        public boolean isPossibleDivide(int[] nums, int k) {

            if (k == 1) {
                return true;
            }
            int n = nums.length;
            if (n % k != 0) {
                return false;
            }
            TreeMap<Integer, Integer> num2CountMap = new TreeMap<>();
            for (int num : nums) {
                num2CountMap.put(num, num2CountMap.getOrDefault(num, 0) + 1);
            }
            int groupNum = n / k;
            for (int ite = 0; ite < groupNum; ++ite) {
                int first = num2CountMap.firstKey();
                int count = num2CountMap.get(first);
                if (count == 1) {
                    num2CountMap.remove(first);
                } else {
                    num2CountMap.replace(first, count - 1);
                }
                for (int i = 1; i < k; ++i) {
                    if (!num2CountMap.containsKey(first + i)) {
                        return false;
                    }
                    count = num2CountMap.get(first + i);
                    if (count == 1) {
                        num2CountMap.remove(first + i);
                    } else {
                        num2CountMap.replace(first + i, count - 1);
                    }
                }
            }
            return true;
        }
    }
}
