import java.util.HashMap;

public class Leetcode523 {

    public boolean checkSubarraySum(int[] nums, int k) {

        int sum = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            sum %= k;
            if (hash.containsKey(sum)) {
                if (i - hash.get(sum) > 1) return true;
            } else {
                hash.put(sum, i);
            }
        }
        return false;
    }
}
