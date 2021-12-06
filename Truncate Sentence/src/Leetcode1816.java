public class Leetcode1816 {

    public String truncateSentence(String s, int k) {

        String[] words = s.split(" ");
        if (words.length <= k) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < k; i++) {
            res.append(words[i]);
            if (i != k - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}
