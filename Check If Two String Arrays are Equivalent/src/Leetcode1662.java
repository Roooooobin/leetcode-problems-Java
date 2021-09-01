public class Leetcode1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        String s1 = String.join("", word1);
        String s2 = String.join("", word2);
        return s1.compareTo(s2) == 0;
    }
}
