import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Leetcode672 {

    public static void main(String[] args) {
        Leetcode672 ins = new Leetcode672();
        ins.flipLights(5, 3);
    }

    public int flipLights(int n, int presses) {

        if (presses == 0) {
            return 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('1');
        }
        String s = sb.toString();
        Deque<String> q = new ArrayDeque<>();
        q.offerLast(s);
        int res = 0;
        while (!q.isEmpty() && presses > 0) {
            int k = q.size();
            presses--;
            HashSet<String> seen = new HashSet<>();
            while (k > 0) {
                k--;
                String front = q.pollFirst();
                for (int i = 1; i <= 4; i++) {
                    String next = flip(front, i);
                    if (!seen.contains(next)) {
                        q.offerLast(next);
                        seen.add(next);
                    }
                }
            }
            if (presses == 0) {
                res = seen.size();
            }
        }
        return res;
    }

    public String flip(String s, int button) {
        switch (button) {
            case 1:
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '1') {
                        sb.append('0');
                    } else {
                        sb.append('1');
                    }
                }
                return sb.toString();
            case 2:
                sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (i % 2 != 0) {
                        sb.append(s.charAt(i));
                        continue;
                    }
                    if (s.charAt(i) == '1') {
                        sb.append('0');
                    } else {
                        sb.append('1');
                    }
                }
                return sb.toString();

            case 3:
                sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (i % 2 != 1) {
                        sb.append(s.charAt(i));
                        continue;
                    }
                    if (s.charAt(i) == '1') {
                        sb.append('0');
                    } else {
                        sb.append('1');
                    }
                }
                return sb.toString();

            case 4:
                sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (i % 3 != 0) {
                        sb.append(s.charAt(i));
                        continue;
                    }
                    if (s.charAt(i) == '1') {
                        sb.append('0');
                    } else {
                        sb.append('1');
                    }
                }
                return sb.toString();

            default:
                return s;
        }
    }

    //    public int flipLights(int n, int presses) {
    //
    //        if (presses == 0) {
    //            return 1;
    //        }
    //        char[] a = new char[n];
    //        Arrays.fill(a, '1');
    //        Deque<char[]> q = new ArrayDeque<>();
    //        q.offerLast(a);
    //        int res = 0;
    //        while (!q.isEmpty() && presses > 0) {
    //            int k = q.size();
    //            presses--;
    //            HashSet<String> seen = new HashSet<>();
    //            while (k > 0) {
    //                k--;
    //                char[] front = q.pollFirst();
    //                for (int i = 1; i <= 4; i++) {
    //                    flip(front, i);
    //                    String status = Arrays.toString(front);
    //                    if (!seen.contains(status)) {
    //                        char[] next = new char[n];
    //                        System.arraycopy(front, 0, next, 0, n);
    //                        q.offerLast(next);
    //                        seen.add(status);
    //                    }
    //                    flip(front, i);
    //                }
    //            }
    //            if (presses == 0) {
    //                res = seen.size();
    //            }
    //        }
    //        return res;
    //    }
    //
    //    public void flip(char[] a, int button) {
    //        switch (button) {
    //            case 1:
    //                for (int i = 0; i < a.length; i++) {
    //                    if (a[i] == '1') {
    //                        a[i] = '0';
    //                    } else {
    //                        a[i] = '1';
    //                    }
    //                }
    //                break;
    //            case 2:
    //                for (int i = 0; i < a.length; i++) {
    //                    if (i % 2 != 0) {
    //                        continue;
    //                    }
    //                    if (a[i] == '1') {
    //                        a[i] = '0';
    //                    } else {
    //                        a[i] = '1';
    //                    }
    //                }
    //                break;
    //            case 3:
    //                for (int i = 0; i < a.length; i++) {
    //                    if (i % 2 != 1) {
    //                        continue;
    //                    }
    //                    if (a[i] == '1') {
    //                        a[i] = '0';
    //                    } else {
    //                        a[i] = '1';
    //                    }
    //                }
    //                break;
    //            case 4:
    //                for (int i = 0; i < a.length; i++) {
    //                    if (i % 3 != 0) {
    //                        continue;
    //                    }
    //                    if (a[i] == '1') {
    //                        a[i] = '0';
    //                    } else {
    //                        a[i] = '1';
    //                    }
    //                }
    //                break;
    //            default:
    //        }
    //    }
}
