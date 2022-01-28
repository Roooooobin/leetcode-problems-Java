import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode1996 {
    class Solution {
        public int numberOfWeakCharacters(int[][] properties) {

            int res = 0;
            Arrays.sort(
                    properties,
                    (o1, o2) -> {
                        if (o1[0] == o2[0]) {
                            return o2[1] - o1[1];
                        } else {
                            return o1[0] - o2[0];
                        }
                    });
            Deque<Integer> stack = new ArrayDeque<>();
            // stack.offerLast(properties[0][1]);
            for (int[] property : properties) {
                while (!stack.isEmpty() && stack.peekLast() < property[1]) {
                    res++;
                    stack.pollLast();
                }
                stack.offerLast(property[1]);
            }
            return res;
        }
    }
}

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {

        int res = 0;
        Arrays.sort(
                properties,
                (o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    } else {
                        return o2[0] - o1[0];
                    }
                });
        int maxDef = 0;
        for (int[] property : properties) {
            if (property[1] < maxDef) {
                res++;
            } else {
                maxDef = property[1];
            }
        }
        return res;
    }
}
