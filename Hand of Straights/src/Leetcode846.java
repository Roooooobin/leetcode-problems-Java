import java.util.TreeMap;

public class Leetcode846 {

    class Solution {

        public boolean isNStraightHand(int[] hand, int groupSize) {

            if (groupSize == 1) {
                return true;
            }
            int n = hand.length;
            if (n % groupSize != 0) {
                return false;
            }
            TreeMap<Integer, Integer> num2CountMap = new TreeMap<>();
            for (int x : hand) {
                num2CountMap.put(x, num2CountMap.getOrDefault(x, 0) + 1);
            }
            int groupNum = n / groupSize;
            for (int ite = 0; ite < groupNum; ++ite) {
                int first = num2CountMap.firstKey();
                int count = num2CountMap.get(first);
                if (count == 1) {
                    num2CountMap.remove(first);
                } else {
                    num2CountMap.replace(first, count - 1);
                }
                for (int i = 1; i < groupSize; ++i) {
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
