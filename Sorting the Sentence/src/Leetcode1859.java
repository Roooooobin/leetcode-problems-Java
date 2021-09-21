public class Leetcode1859 {

    public String sortSentence(String s) {

        String[] a = s.split(" ");
        String[] res = new String[a.length];
        for (String s1 : a) {
            res[s1.charAt(s1.length() - 1) - '1'] = s1.substring(0, s1.length() - 1);
        }
        StringBuilder ret = new StringBuilder();
        ret.append(res[0]);
        for (int i = 1; i < res.length; i++) {
            ret.append(" ");
            ret.append(res[i]);
        }
        return ret.toString();
    }
}
