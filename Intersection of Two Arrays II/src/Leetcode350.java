import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hash1 = new HashMap<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        for (int num : nums1) {
            hash1.put(num, hash1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            hash2.put(num, hash2.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> l = new ArrayList<>();
        for (int num : hash1.keySet()) {
            for (int i = 0; i < Math.min(hash1.get(num), hash2.getOrDefault(num, 0)); i++) {
                l.add(num);
            }
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }
}
