import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class Leetcode433 {

    public int minMutation(String start, String end, String[] bank) {

        int res = 0;
        char[] genes = new char[] {'A', 'C', 'G', 'T'};
        HashSet<String> validSeq = new HashSet<>(Arrays.asList(bank));
        int n = start.length();
        Deque<String> q = new ArrayDeque<>();
        HashSet<String> seen = new HashSet<>();
        q.offerLast(start);
        seen.add(start);
        while (!q.isEmpty()) {

            int k = q.size();
            while (k > 0) {
                k--;
                String front = q.pollFirst();
                if (front.equals(end)) {
                    return res;
                }
                String next;
                for (int i = 0; i < n; i++) {
                    // try all possible mutations
                    for (char g : genes) {
                        next = front.substring(0, i) + g + front.substring(i + 1);
                        if (validSeq.contains(next) && !seen.contains(next)) {
                            q.offerLast(next);
                            seen.add(next);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }
}
