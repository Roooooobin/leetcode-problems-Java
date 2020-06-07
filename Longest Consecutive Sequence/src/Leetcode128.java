import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int longest = 0;
        for (int x : nums) {
            if (!set.contains(x-1)) {
                int num = x;
                int curLongest = 1;
                while (set.contains(num+1)) {
                    num += 1;
                    curLongest += 1;
                }
                longest = Math.max(curLongest, longest);
            }
        }
        return longest;
    }
}
