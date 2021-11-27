import java.util.HashMap;
import java.util.Random;

public class Leetcode519 {

    /*
    https://leetcode-cn.com/problems/random-flip-matrix/solution/gong-shui-san-xie-note-bie-pian-yi-ti-sh-e6gi/
     */
    class Solution {

        int m, n;
        int leftoverIdx;
        HashMap<Integer, Integer> hash = new HashMap<>();
        Random random = new Random();

        public Solution(int m_, int n_) {

            m = m_;
            n = n_;
            leftoverIdx = m * n;
        }

        public int[] flip() {

            int x = random.nextInt(leftoverIdx--);
            int idx = hash.getOrDefault(x, x);
            hash.put(x, hash.getOrDefault(leftoverIdx, leftoverIdx));
            return new int[] {idx / n, idx % n};
        }

        public void reset() {

            leftoverIdx = m * n;
            hash.clear();
        }
    }
}
