import java.util.Arrays;

public class Leetcode537 {

    public String complexNumberMultiply(String num1, String num2) {

        int[] num1RI = parseRealAndImaginary(num1);
        int[] num2RI = parseRealAndImaginary(num2);
        int real = num1RI[0] * num2RI[0] - num1RI[1] * num2RI[1];
        int imaginary = num1RI[0] * num2RI[1] + num1RI[1] * num2RI[0];
        StringBuilder res = new StringBuilder();
        res.append(real);
        res.append('+');
        res.append(imaginary);
        res.append('i');
        return res.toString();
    }

    public int[] parseRealAndImaginary(String num) {

        int i;
        int[] res = new int[2];
        for (i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '+') {
                break;
            }
        }
        res[0] = Integer.parseInt(num.substring(0, i));
        res[1] = Integer.parseInt(num.substring(i + 1, num.length() - 1));

        return res;
    }

    public static void main(String[] args) {
        String s = "1+1i2#m";
        System.out.println(Arrays.toString(s.split("[+i#]")));
    }

    public class Solution {

        public String complexNumberMultiply(String a, String b) {
            String[] x = a.split("[+i]");
            String[] y = b.split("[+i]");
            System.out.println(Arrays.toString(x));
            int a_real = Integer.parseInt(x[0]);
            int a_img = Integer.parseInt(x[1]);
            int b_real = Integer.parseInt(y[0]);
            int b_img = Integer.parseInt(y[1]);
            return (a_real * b_real - a_img * b_img)
                    + "+"
                    + (a_real * b_img + a_img * b_real)
                    + "i";
        }
    }

    /*
    作者：LeetCode
    链接：https://leetcode-cn.com/problems/complex-number-multiplication/solution/fu-shu-cheng-fa-by-leetcode/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
