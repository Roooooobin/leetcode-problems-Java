public class Leetcode1884 {

    public int twoEggDrop(int n) {

        int x = 1;
        while ((x + 1) * x / 2 < n) {
            x++;
        }
        return x;
    }
}
