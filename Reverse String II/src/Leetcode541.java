public class Leetcode541 {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] a = s.toCharArray();
        for (int st=0; st<n; st+=2*k) {
            int i = st;
            int j = Math.min(st+k-1, n-1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
