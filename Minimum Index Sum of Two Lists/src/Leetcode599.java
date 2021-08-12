import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode599 {

    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> hash1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hash1.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (!hash1.containsKey(list2[i])) {
                continue;
            }
            minSum = Math.min(minSum, i + hash1.get(list2[i]));
        }
        for (int i = 0; i < list2.length; i++) {
            if (!hash1.containsKey(list2[i])) {
                continue;
            }
            if (i + hash1.get(list2[i]) == minSum) {
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[0]);
    }
}
