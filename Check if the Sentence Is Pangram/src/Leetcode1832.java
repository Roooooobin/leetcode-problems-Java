public class Leetcode1832 {

    public boolean checkIfPangram(String sentence) {

        int bitHash = 0;
        int tar = (1 << 26) - 1;
        for (int i = 0; i < sentence.length(); i++) {
            int num = (1 << (sentence.charAt(i) - 'a'));
            if ((bitHash & num) == 0) {
                bitHash ^= num;
            }
            if ((bitHash ^ tar) == 0) {
                return true;
            }
        }
        return false;
    }
}
