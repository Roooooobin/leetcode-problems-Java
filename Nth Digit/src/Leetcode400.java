public class Leetcode400 {

    public int findNthDigit(int n) {
        long d = 1, count = 9;
        // x digits number has 9 * 10 ^ (x-1)
        while (n > d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        // find d
        // nth number in digits: d
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = (int) (start + index / d);
        int digitIndex = (int) (index % d);
        return (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
    }
}
