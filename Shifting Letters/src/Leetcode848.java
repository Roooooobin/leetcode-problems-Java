public class Leetcode848 {

    public String shiftingLetters(String s, int[] shifts) {

        int n = s.length();
        long[] suffixSum = new long[n];
        suffixSum[n - 1] = shifts[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + (long) shifts[i];
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - 'a';
            res.append((char) ('a' + (num + suffixSum[i] % 26) % 26));
        }
        return res.toString();
    }
}
