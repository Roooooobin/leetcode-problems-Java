public class Leetcode9 {
    public boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s).reverse();
        System.out.println(s + sb);
        return s.equals(sb.toString());
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int num = 0;
        while (num < x) {
            num = num * 10 + x % 10;
            x /= 10;
        }
        return num == x || num / 10 == x;
    }
}
