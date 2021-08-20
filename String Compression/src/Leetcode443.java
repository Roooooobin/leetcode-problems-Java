public class Leetcode443 {

    public int compress(char[] chars) {

        int resLen = 0;
        int n = chars.length;
        if (n == 1) {
            return 1;
        }
        char pre = chars[0];
        int count = 1;
        int i = 1;
        while (i < n) {

            while (i < n && chars[i] == pre) {
                i++;
                count++;
            }
            int[] digits = calcDigits(count);
            chars[resLen++] = pre;
            if (count != 1) {
                for (int digit : digits) {
                    chars[resLen++] = (char) (digit + '0');
                }
            }
            if (i < n) {
                pre = chars[i++];
                if (i == n) {
                    chars[resLen++] = pre;
                }
            }
            count = 1;
        }

        return resLen;
    }

    public int[] calcDigits(int i) {

        int count = 0;
        int x = i;
        while (i > 0) {
            count++;
            i /= 10;
        }
        int[] res = new int[count];
        while (count > 0) {
            res[count - 1] = x % 10;
            x /= 10;
            count--;
        }
        return res;
    }

    class Solution {
        public int compress(char[] chars) {
            int n = chars.length;
            int resLen = 0, l = 0;
            for (int i = 0; i < n; i++) {
                if (i == n - 1 || chars[i] != chars[i + 1]) {
                    chars[resLen++] = chars[i];
                    int count = i - l + 1;
                    if (count > 1) {
                        int[] digits = calcDigits(count);
                        for (int digit : digits) {
                            chars[resLen++] = (char) (digit + '0');
                        }
                    }
                    l = i + 1;
                }
            }
            return resLen;
        }

        public int[] calcDigits(int i) {

            int count = 0;
            int x = i;
            while (i > 0) {
                count++;
                i /= 10;
            }
            int[] res = new int[count];
            while (count > 0) {
                res[count - 1] = x % 10;
                x /= 10;
                count--;
            }
            return res;
        }
    }
}
