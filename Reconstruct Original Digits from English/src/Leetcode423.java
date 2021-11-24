import java.util.HashMap;

public class Leetcode423 {

    public String originalDigits(String s) {
        HashMap<Character, Integer> c = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }

        int[] cnt = new int[10];
        // only zero has z
        cnt[0] = c.getOrDefault('z', 0);
        // only two has w
        cnt[2] = c.getOrDefault('w', 0);
        // only four has u
        cnt[4] = c.getOrDefault('u', 0);
        // only six has x
        cnt[6] = c.getOrDefault('x', 0);
        // only eight has g
        cnt[8] = c.getOrDefault('g', 0);

        // three = num(h) - eight
        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        // five = num(f) - four
        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        // seven = num(s) - six
        cnt[7] = c.getOrDefault('s', 0) - cnt[6];
        // one = num(o) - zero - two - four
        cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];
        // nine = num(i) - five - six - eight
        cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            res.append(String.valueOf((char) (i + '0')).repeat(Math.max(0, cnt[i])));
        }
        return res.toString();
    }
}
