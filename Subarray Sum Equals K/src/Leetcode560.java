import java.util.HashMap;

public class Leetcode560 {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for(int i=0; i<nums.length; ++i){
            sum += nums[i];
            cnt += hash.getOrDefault(sum-k, 0);
            hash.put(sum, hash.getOrDefault(sum, 0)+1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};

    }
}
