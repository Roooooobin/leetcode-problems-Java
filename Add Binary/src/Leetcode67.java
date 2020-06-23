public class Leetcode67 {
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    // overflow
    public String addBinary2(String a, String b) {
        int x = Integer.parseInt(a, 2);
        int y = Integer.parseInt(b, 2);
        while (y != 0) {
            int ans = x ^ y;
            int carry = (x & y) << 1;
            x = ans;
            y = carry;
        }
        return Integer.toBinaryString(x);
    }
}
