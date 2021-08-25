public class Leetcode1754 {

    public String largestMerge(String word1, String word2) {

        StringBuilder res = new StringBuilder();
        int n1 = word1.length(), n2 = word2.length();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (word1.substring(i).compareTo(word2.substring(j)) > 0) {
                res.append(word1.charAt(i++));
            } else {
                res.append(word2.charAt(j++));
            }
        }
        if (i < n1) {
            for (; i < n1; i++) {
                res.append(word1.charAt(i));
            }
        }
        if (j < n2) {
            for (; j < n2; j++) {
                res.append(word2.charAt(j));
            }
        }
        return res.toString();
    }
}
