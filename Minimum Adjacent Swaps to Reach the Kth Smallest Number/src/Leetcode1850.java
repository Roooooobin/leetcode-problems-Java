public class Leetcode1850 {

    public int getMinSwaps(String num, int k) {

        char[] tar = num.toCharArray();
        int n = tar.length;
        while (k > 0) {
            k--;
            int i = n - 1;
            while (i > 0 && (tar[i - 1] >= tar[i])) {
                i--;
            }
            if (i == 0) {
                return -1;
            }
            // 第一个升序对
            char x = tar[i - 1];
            int j;
            for (j = n - 1; j >= i; j--) {
                if (tar[j] > x) {
                    break;
                }
            }
            swap(tar, i - 1, j);
            reverse(tar, i, n - 1);
        }
        int res = 0;
        char[] orig = num.toCharArray();
        int st = 0;
        for (int i = 0; i < n; i++) {
            if (orig[i] != tar[i]) {
                st = i;
                break;
            }
        }
        // 从orig到tar需要交换多少次
        for (int i = st; i < n; i++) {
            int j;
            for (j = i; j < n; j++) {
                if (tar[i] == orig[j]) {
                    break;
                }
            }
            if (i == j) {
                continue;
            }
            res += (j - i);
            for (k = j; k > i; k--) {
                swap(orig, k, k - 1);
            }
        }
        return res;
    }

    public void swap(char[] a, int l, int r) {

        char c = a[l];
        a[l] = a[r];
        a[r] = c;
    }

    public void reverse(char[] a, int l, int r) {
        while (l <= r) {
            swap(a, l, r);
            l++;
            r--;
        }
    }
}
