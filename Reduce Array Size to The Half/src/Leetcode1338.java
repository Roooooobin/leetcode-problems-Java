import java.util.*;

public class Leetcode1338 {

    public int minSetSize(int[] arr) {

        Map<Integer, Integer> hash = new TreeMap<>();
        Integer[] nums = new Integer[arr.length];
        int i = 0;
        for (int num : arr) {
            hash.put(num, hash.getOrDefault(num, 0) + 1);
            nums[i++] = num;
        }
        Arrays.sort(
                nums,
                (o1, o2) -> {
                    int c1 = hash.get(o1);
                    int c2 = hash.get(o2);
                    if (c1 == c2) return o1 - o2;
                    else return c2 - c1;
                });
        //        System.out.println(Arrays.toString(nums));
        Set<Integer> set = new HashSet<>();
        for (i = 0; i < (arr.length + 1) / 2; ++i) {
            set.add(nums[i]);
        }

        return set.size();
    }
}
