public class Leetcode1903 {

    public String largestOddNumber(String num) {

        int idx;
        for (idx = num.length() - 1; idx >= 0; idx--) {
            if (((num.charAt(idx) - '0') & 1) == 1) {
                break;
            }
        }
        if (idx == -1) {
            return "";
        }
        return num.substring(0, idx + 1);
    }
}
