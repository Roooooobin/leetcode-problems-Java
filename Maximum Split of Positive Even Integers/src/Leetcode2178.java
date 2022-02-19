import java.util.ArrayList;
import java.util.List;

public class Leetcode2178 {

    class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {

            List<Long> res = new ArrayList<>();
            if (finalSum % 2 == 1) {
                return res;
            }
            long tmp = finalSum;
            for (long i = 2; i <= finalSum; i += 2) {
                if (i * 2 + 2 > tmp) {
                    res.add(tmp);
                    break;
                } else {
                    res.add(i);
                }
                tmp -= i;
            }
            return res;
        }
    }
}
