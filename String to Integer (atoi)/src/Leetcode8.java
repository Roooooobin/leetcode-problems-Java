public class Leetcode8 {
    public static int myAtoi(String str) {
        if (str.length() == 0) return 0;
        final char MAXVALUEMOD = '7';
        int sign = 1;
        int ans = 0;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) return 0;
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            sign = str.charAt(i) == '+' ? 1 : -1;
            ++i;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && str.charAt(i) > MAXVALUEMOD)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            ans = ans * 10 + (str.charAt(i++) - '0');
        }
        return ans * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("     -433"));
    }
}
