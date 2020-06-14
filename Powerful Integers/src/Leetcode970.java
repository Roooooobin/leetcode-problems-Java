import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode970 {
    public List<Integer> powerfulIntegers_(int x, int y, int bound) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(1);
        if (x != 1) {
            int factor = x;
            while (x <= bound) {
                a.add(x);
                x *= factor;
            }
        }
        if (y != 1) {
            int factor = y;
            while (y <= bound) {
                b.add(y);
                y *= factor;
            }
        }
        Set<Integer> res = new HashSet<>();
        for (int u : a) {
            for (int v : b) {
                if (u + v > bound) break;
                res.add(u + v);
            }
        }
        return new ArrayList<>(res);
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i=1; i<bound; i*=x) {
            for (int j=1; i+j<=bound; j*=y) {
                set.add(i+j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(set);
    }
}
