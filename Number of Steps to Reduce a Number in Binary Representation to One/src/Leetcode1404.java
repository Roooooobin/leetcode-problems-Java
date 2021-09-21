public class Leetcode1404 {

    int len;

    public char[] addOne(char[] a) {

        int idx = len - 1;
        while (idx >= 0) {
            if (a[idx] == '1') {
                a[idx--] = '0';
            } else {
                a[idx] = '1';
                break;
            }
        }
        if (idx < 0) {
            char[] res = new char[len + 1];
            res[0] = '1';
            System.arraycopy(a, 0, res, 1, len);
            len++;
            return res;
        } else {
            return a;
        }
    }

    //    public static void main(String[] args) {
    //        char[] a = {'1', '0', '0', '0'};
    //        System.out.println(addOne(a, 3));
    //    }

    public int numSteps(String s) {

        int res = 0;
        char[] a = s.toCharArray();
        len = a.length;
        while (len != 1) {
            if (a[len - 1] == '1') {
                a = addOne(a);
            } else {
                len--;
            }
            res++;
        }
        return res;
    }
}
