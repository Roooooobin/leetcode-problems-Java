import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetcodeReview1002 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hash = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s1 = Arrays.toString(chars);
            if (hash.containsKey(s1)) {
                hash.get(s1).add(s);
            } else {
                ArrayList<String> arr = new ArrayList<>();
                arr.add(s);
                hash.put(s1, arr);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (String s : hash.keySet()) {
            ans.add(hash.get(s));
        }
        return ans;
    }
}
