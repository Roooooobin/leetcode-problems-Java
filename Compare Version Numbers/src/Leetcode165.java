public class Leetcode165 {

    public int compare(String u, String v) {

        int i = 0, j = 0;
        int m = u.length(), n = v.length();
        int a = 0, b = 0;
        while (i < m) {
            a = a * 10 + (u.charAt(i++) - '0');
        }
        while (j < n) {
            b = b * 10 + (v.charAt(j++) - '0');
        }
        return Integer.compare(a, b);
    }

    public int compareVersion(String version1, String version2) {

        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int i = 0, j = 0;
        int m = a.length, n = b.length;
        while (i < m && j < n) {
            int res = compare(a[i++], b[j++]);
            if (res != 0) {
                return res;
            }
        }
        while (i < m && Integer.parseInt(a[i]) == 0) {
            i++;
        }
        while (j < n && Integer.parseInt(b[j]) == 0) {
            j++;
        }
        if (i == m && j == n) {
            return 0;
        } else if (i == m && j < n) {
            return -1;
        } else {
            return 1;
        }
    }

    class Solution {
        public int compareVersion(String version1, String version2) {
            String[] a = version1.split("\\.");
            String[] b = version2.split("\\.");
            int i = 0;
            int m = a.length, n = b.length;
            while (i < m || i < n) {
                int x = 0, y = 0;
                if (i < m) {
                    x = Integer.parseInt(a[i]);
                }
                if (i < n) {
                    y = Integer.parseInt(b[i]);
                }
                if (x > y) {
                    return 1;
                } else if (x < y) {
                    return -1;
                }
                i++;
            }
            return 0;
        }
    }
}
