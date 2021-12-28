import java.util.HashSet;

public class Leetcode898 {

    public int subarrayBitwiseORs(int[] arr) {

        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int i : arr) {
            HashSet<Integer> next = new HashSet<>();
            for (int j : cur) {
                next.add(i | j);
            }
            // 把i补回去
            next.add(i);
            cur = next;
            res.addAll(cur);
        }
        return res.size();
    }
}
