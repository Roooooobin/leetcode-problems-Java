public class Leetcode1255 {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int res = 0;
        int[] letterCountMap = new int[26];
        for (char letter : letters) {
            letterCountMap[letter - 'a']++;
        }
        int n = words.length;
        int m = 1 << n;
        for (int i = 1; i < m; i++) {
            int idx = 0;
            int[] curCountMap = new int[26];
            int x = i;
            boolean flag = true;
            int curScore = 0;
            while (x > 0) {
                if ((x & 1) == 1) {
                    String word = words[idx];
                    for (int j = 0; j < word.length(); j++) {
                        int c = word.charAt(j) - 'a';
                        curCountMap[c]++;
                        if (curCountMap[c] > letterCountMap[c]) {
                            flag = false;
                            break;
                        }
                        curScore += score[c];
                    }
                }

                x >>= 1;
                idx++;
            }
            if (flag) {
                res = Math.max(res, curScore);
            }
        }
        return res;
    }
}
