public class Leetcode1736 {

    public String maximumTime(String time) {

        StringBuilder res = new StringBuilder();
        char h1 = time.charAt(0);
        char h2 = time.charAt(1);
        if (h1 == '?') {
            if (h2 >= '4' && h2 != '?') {
                res.append('1');
            } else {
                res.append('2');
            }
        } else {
            res.append(h1);
        }
        if (h2 == '?') {
            if (h1 == '?' || h1 == '2') {
                res.append('3');
            } else {
                res.append('9');
            }
        } else {
            res.append(h2);
        }
        res.append(':');
        char m1 = time.charAt(3);
        if (m1 == '?') {
            res.append('5');
        } else {
            res.append(m1);
        }
        char m2 = time.charAt(4);
        if (m2 == '?') {
            res.append('9');
        } else {
            res.append(m2);
        }

        return res.toString();
    }
}
