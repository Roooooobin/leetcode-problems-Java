import java.util.HashMap;

public class Leetcode825 {

    public int numFriendRequests(int[] ages) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int age : ages) {
            hash.put(age, hash.getOrDefault(age, 0) + 1);
        }
        int res = 0;
        for (int x : hash.keySet()) {
            for (int y : hash.keySet()) {
                if (doSendRequest(x, y)) {
                    res += hash.get(x) * (hash.get(y) - (x == y ? 1 : 0));
                }
            }
        }
        return res;
    }

    public boolean doSendRequest(int x, int y) {

        if (y <= ((x >> 1) + 7)) {
            return false;
        }
        return y <= x;
    }
}
