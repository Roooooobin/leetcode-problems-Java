import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Leetcode398 {

    class Solution2 {

        HashMap<Integer, ArrayList<Integer>> val2Indexes;
        Random random = new Random();

        public Solution2(int[] nums) {

            val2Indexes = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                ArrayList<Integer> l = val2Indexes.getOrDefault(nums[i], new ArrayList<>());
                l.add(i);
                val2Indexes.put(nums[i], l);
            }
        }

        public int pick(int target) {

            ArrayList<Integer> l = val2Indexes.get(target);
            int n = l.size();
            if (n == 1) {
                return l.get(0);
            }
            int reserved = l.get(0);
            for (int i = 0; i < n; i++) {
                int v = random.nextInt(i + 1);
                if (v == 0) {
                    reserved = l.get(i);
                }
            }
            return reserved;
        }
    }

    class Solution {

        int[] nums;
        Random random;

        public Solution(int[] nums_) {

            nums = nums_;
            random = new Random();
        }

        public int pick(int target) {

            int reserved = 0;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    cnt++;
                    int v = random.nextInt(cnt);
                    if (v == 0) {
                        reserved = i;
                    }
                }
            }
            return reserved;
        }
    }
}
