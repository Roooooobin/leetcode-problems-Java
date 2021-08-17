public class Leetcode551 {

    public boolean checkRecord(String s) {

        int countA = 0, countL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                if (countA == 1) {
                    return false;
                }
                countA++;
                countL = 0;
            } else if (s.charAt(i) == 'L') {
                if (countL == 2) {
                    return false;
                }
                countL++;
            } else {
                countL = 0;
            }
        }
        return true;
    }
}
