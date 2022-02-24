import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode2182 {

    public String repeatLimitedString(String s, int repeatLimit) {

        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash[c - 'a']++;
        }
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 25; i >= 0; i--) {
            if (hash[i] > 0) {
                q.offerLast((char) (i + 'a'));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {

            char front = q.pollFirst();
            int cnt = Math.min(hash[front - 'a'], repeatLimit);
            res.append(String.valueOf(front).repeat(cnt));
            hash[front - 'a'] -= cnt;
            if (hash[front - 'a'] != 0) {
                if (q.isEmpty()) {
                    break;
                } else {
                    char secondFront = q.pollFirst();
                    res.append(secondFront);
                    hash[secondFront - 'a']--;
                    if (hash[secondFront - 'a'] != 0) {
                        q.offerFirst(secondFront);
                    }
                }
                q.offerFirst(front);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Leetcode2182 ins = new Leetcode2182();
        System.out.println(ins.repeatLimitedString("aababab", 2));
    }
}
