import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Jianzhi114 {

    public static void main(String[] args) {
        String[] words = new String[] {"wrt", "wrf", "er", "ett", "rftt"};
        Jianzhi114 ins = new Jianzhi114();
        ins.alienOrder(words);
    }

    public String alienOrder(String[] words) {

        int[] inDegree = new int[26];
        HashSet<Integer>[] adjacentMap = new HashSet[26];
        HashSet<Integer> exists = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            adjacentMap[i] = new HashSet<>();
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                exists.add(word.charAt(j) - 'a');
            }
            for (int j = i + 1; j < words.length; j++) {
                int idx = indexOfFirstDifferentCharacter(word, words[j]);
                if (idx == -2) {
                    return "";
                }
                if (idx == -1) {
                    continue;
                }
                int ci = word.charAt(idx) - 'a', cj = words[j].charAt(idx) - 'a';
                if (!adjacentMap[ci].contains(cj)) {
                    inDegree[cj]++;
                    adjacentMap[ci].add(cj);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();
        for (Integer x : exists) {
            if (inDegree[x] == 0) {
                q.offerLast(x);
            }
        }
        while (!q.isEmpty()) {
            int front = q.pollFirst();
            res.append((char) (front + 'a'));
            for (int x : adjacentMap[front]) {
                inDegree[x]--;
                if (inDegree[x] == 0) {
                    q.offerLast(x);
                }
            }
        }

        if (res.length() != exists.size()) {
            return "";
        }
        return res.toString();
    }

    public int indexOfFirstDifferentCharacter(String s, String t) {

        int i = 0;
        while (i < s.length() && i < t.length()) {
            if (s.charAt(i) != t.charAt(i)) {
                return i;
            }
            i++;
        }
        // 不满足题中预设
        if (s.length() > t.length()) {
            return -2;
        }
        return -1;
    }
}
