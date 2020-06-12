public class Leetcode12 {
    public static String intToRomanSmart(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            while (num >= number[i]) {
                num -= number[i];
                ans.append(roman[i]);
            }
            ++i;    // 数字值从大到小，所以直接往下遍历就可，不需要每次都重复整个遍历
        }
        return ans.toString();
    }
}
