public class Leetcode482 {

    public String licenseKeyFormatting(String s, int k) {

        String split = String.join("", s.split("-")).toUpperCase();
        int len = split.length();
        int n = len / k + 1;
        int firstLen = len % k;
        if (firstLen == 0) {
            n--;
            firstLen = k;
        }
        String[] strings = new String[n];
        int start = 0;
        for (int i = 0; i < n; i++) {
            int end = start + k;
            if (i == 0) {
                end = start + firstLen;
            }
            strings[i] = split.substring(start, end);
            start = end;
        }
        return String.join("-", strings);
    }
}
