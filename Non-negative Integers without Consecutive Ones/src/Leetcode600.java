public class Leetcode600 {

    /*
    https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/solution/
     */
    public int findIntegers(int n) {

        return 1 + countValidInts(1, n);
    }

    public int countValidInts(int x, int limit) {
        if (x > limit) {
            return 0;
        }

        if ((x & 1) == 1) {

            return 1 + countValidInts(x << 1, limit);
        } else {

            return 1 + countValidInts(x << 1, limit) + countValidInts((x << 1) | 1, limit);
        }
    }
}
