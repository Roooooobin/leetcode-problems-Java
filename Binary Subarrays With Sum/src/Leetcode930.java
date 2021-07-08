import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode930 {

    // too complicated
    public int numSubarraysWithSum2(int[] nums, int goal) {

        // 记录出现的第i个1的位置
        ArrayList<Integer> onePositionList = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                onePositionList.add(i);
            }
        }

        int res = 0;
        if (goal == 0) {
            int len = onePositionList.size();
            if (len == 0) {
                return n * (n + 1) / 2;
            }
            res += onePositionList.get(0) * (onePositionList.get(0) + 1) / 2;
            for (int i = 1; i < len; ++i) {
                int idx = onePositionList.get(i);
                int idxPre = onePositionList.get(i - 1);
                res += (idx - 1 - idxPre) * (idx - idxPre) / 2;
            }
            res += (n - 1 - onePositionList.get(len - 1)) * (n - onePositionList.get(len - 1)) / 2;
        } else {
            for (int i = 0; i <= onePositionList.size() - goal; ++i) {
                int left, right;
                if (i == 0) {
                    left = onePositionList.get(0) + 1;
                } else {
                    left = onePositionList.get(i) - onePositionList.get(i - 1);
                }
                if (i == onePositionList.size() - goal) {
                    right = n - onePositionList.get(i + goal - 1);
                } else {
                    right = onePositionList.get(i + goal) - onePositionList.get(i + goal - 1);
                }
                res += right * left;
            }
        }

        return res;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
            sum += num;
            res += hash.getOrDefault(sum - goal, 0);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode930 ins = new Leetcode930();
        int[] arr = new int[] {0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1};
        System.out.println(ins.numSubarraysWithSum(arr, 0));
    }
}
