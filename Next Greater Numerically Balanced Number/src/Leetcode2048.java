public class Leetcode2048 {

    public int nextBeautifulNumber(int n) {

        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            if (check(i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean check(int x) {

        int[] hash = new int[10];
        while (x > 0) {
            hash[x % 10]++;
            x /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (hash[i] != 0 && hash[i] != i) {
                return false;
            }
        }
        return true;
    }
}
