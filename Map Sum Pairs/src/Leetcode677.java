import java.util.HashMap;

public class Leetcode677 {

    class MapSum {

        HashMap<String, Integer> hash;
        /** Initialize your data structure here. */
        public MapSum() {
            hash = new HashMap<>();
        }

        public void insert(String key, int val) {
            hash.put(key, val);
        }

        public int sum(String prefix) {

            int res = 0;
            for (String key : hash.keySet()) {
                int idx = key.indexOf(prefix);
                if (idx != 0) continue;
                res += hash.get(key);
            }
            return res;
        }
    }
}
