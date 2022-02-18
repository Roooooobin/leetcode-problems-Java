public class Leetcode402 {

    public String removeKdigits(String num, int k) {

        if (num.length() <= k) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && res.length() != 0 && c < res.charAt(res.length() - 1)) {
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            res.append(c);
        }

        while (k > 0) {
            res.deleteCharAt(res.length() - 1);
            k--;
        }
        int headingZero = 0;
        while (headingZero < res.length() && res.charAt(headingZero) == '0') {
            headingZero++;
        }
        if (headingZero == res.length()) {
            return "0";
        }
        return res.substring(headingZero);
    }

    public static void main(String[] args) {

        Leetcode402 ins = new Leetcode402();
        System.out.println(ins.removeKdigits("10001", 4));
    }
}
