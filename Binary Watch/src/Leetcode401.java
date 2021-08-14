import java.util.ArrayList;
import java.util.List;

public class Leetcode401 {

    public List<String> readBinaryWatch(int turnedOn) {

        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    String s = h + ":" + (m < 10 ? "0" : "") + m;
                    res.add(s);
                }
            }
        }
        return res;
    }
}
