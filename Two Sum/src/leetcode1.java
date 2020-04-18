import java.util.Arrays;
import java.util.HashMap;

public class leetcode1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<nums.length; ++i){
            if(hash.containsKey(target-nums[i])){
                return new int[]{hash.get(target-nums[i]), i};
            }
            hash.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");  // will never reach actually
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
