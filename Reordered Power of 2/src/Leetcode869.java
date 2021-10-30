import java.util.ArrayList;

public class Leetcode869 {

    public boolean reorderedPowerOf2(int n) {

        int digits = calcDigits(n);
        ArrayList<Integer> candidates = new ArrayList<>();
        int x = 1;
        while (calcDigits(x) < digits) {
            x *= 2;
        }
        while (calcDigits(x) == digits) {
            candidates.add(x);
            x *= 2;
        }
        for (Integer candidate : candidates) {
            if (sameNumOfEachDigit(candidate, n)) {
                return true;
            }
        }
        return false;
    }

    public boolean sameNumOfEachDigit(int x, int y) {

        int[] ax = new int[10];
        int[] ay = new int[10];
        while (x > 0) {
            ax[x % 10]++;
            x /= 10;
        }
        while (y > 0) {
            ay[y % 10]++;
            y /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (ax[i] != ay[i]) {
                return false;
            }
        }
        return true;
    }

    public int calcDigits(int x) {
        int digits = 0;
        while (x > 0) {
            digits++;
            x /= 10;
        }
        return digits;
    }
}
