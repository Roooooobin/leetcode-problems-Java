import java.util.ArrayList;
import java.util.List;

public class Leetcode990 {
    private int[] parent = new int[26];

    public int rfind(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void combine(int x, int y) {
        x = rfind(x);
        y = rfind(y);
        if (x != y) {
            parent[x] = y;
        }
    }

    public boolean equationsPossible(String[] equations) {
        for (int i=0; i<parent.length; ++i) {
            parent[i] = i;
        }
        List<String> inequations = new ArrayList<>();
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                combine(e.charAt(0)-'a', e.charAt(3)-'a');
            }
            else {
                inequations.add(e);
            }
        }
        for (String i : inequations) {
            if (rfind(i.charAt(0)-'a') == rfind(i.charAt(3)-'a')) {
                return false;
            }
        }
        return true;
    }
}
