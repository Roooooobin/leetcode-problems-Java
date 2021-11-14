import java.util.ArrayList;

public class Leetcode1286 {

    static class CombinationIterator {
        ArrayList<String> combinations;
        int idx = 0;

        public CombinationIterator(String characters, int combinationLength) {

            combinations = new ArrayList<>();
            dfs(characters, 0, combinationLength, "");
            System.out.println(combinations);
        }

        public String next() {
            return combinations.get(idx++);
        }

        public boolean hasNext() {
            return idx < combinations.size();
        }

        public void dfs(String a, int idx, int n, String cur) {

            // not enough characters to make it n
            if (cur.length() + a.length() - idx < n) {
                return;
            }
            if (cur.length() == n) {
                combinations.add(cur);
                return;
            }
            for (int i = idx; i < a.length(); i++) {
                dfs(a, i + 1, n, cur + a.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        Leetcode1286 ins = new Leetcode1286();
        Leetcode1286.CombinationIterator combinationIterator = new CombinationIterator("abcdef", 3);
    }
}
