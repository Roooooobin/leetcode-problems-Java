import java.util.ArrayList;
import java.util.HashMap;

public class Leetcode981 {

    class TimeMap {

        /** Initialize your data structure here. */
        HashMap<String, ArrayList<Integer>> key2Time;

        HashMap<String, String> key2Value;

        public TimeMap() {

            key2Time = new HashMap<>();
            key2Value = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {

            ArrayList<Integer> l = key2Time.getOrDefault(key, new ArrayList<>());
            l.add(timestamp);
            key2Time.put(key, l);
            key2Value.put(key + timestamp, value);
        }

        public String get(String key, int timestamp) {

            if (!key2Time.containsKey(key)) {
                return "";
            }

            ArrayList<Integer> l = key2Time.get(key);
            // 二分搜索timestamp对应的下标
            int lo = 0, hi = l.size();
            while (lo < hi) {
                int mid = lo + ((hi - lo) >> 1);
                if (l.get(mid) <= timestamp) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (lo == 0) {
                return "";
            } else {
                return key2Value.get(key + l.get(lo - 1));
            }
        }
    }
}

/*
class TimeMap {

HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new TreeMap()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        Integer time = map.get(key).floorKey(timestamp);
        if(time == null) {
            return "";
        }
        return map.get(key).get(time);
    }
}
 */
