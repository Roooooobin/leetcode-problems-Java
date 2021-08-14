public class Leetcode405 {

    public String toHex(int num) {

        if (num == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        char[] hex = "0123456789abcdef".toCharArray();
        while (num != 0) {
            int mod = num & 0xf;
            res.append(hex[mod]);
            num >>>= 4;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Leetcode405 ins = new Leetcode405();
        System.out.println(ins.toHex(-1));
    }
}
