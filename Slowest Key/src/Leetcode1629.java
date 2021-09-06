public class Leetcode1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int n = releaseTimes.length;
        int[] char2DurationMap = new int[128];
        char2DurationMap[keysPressed.charAt(0) - 'a'] = releaseTimes[0];
        char res = keysPressed.charAt(0);
        int max = releaseTimes[0];
        for (int i = 1; i < n; i++) {
            char c = keysPressed.charAt(i);
            if (char2DurationMap[c] != 0) {
                char2DurationMap[c] =
                        Math.max(char2DurationMap[c], releaseTimes[i] - releaseTimes[i - 1]);
            } else {
                char2DurationMap[c] = releaseTimes[i] - releaseTimes[i - 1];
            }
            if (char2DurationMap[c] > max) {
                max = char2DurationMap[c];
                res = c;
            } else if (char2DurationMap[c] == max) {
                if (res < c) {
                    res = c;
                }
            }
        }

        return res;
    }
}
