import java.util.ArrayList;
import java.util.HashMap;

public class LeetcodeLPC07 {

    HashMap<Integer, ArrayList<Integer>> relationMap;
    int[][] relation;
    int n;
    int k;
    int ans = 0;

    public int numWays(int n, int[][] relation, int k) {

        this.relationMap = new HashMap<>();
        this.relation = relation;
        this.n = n;
        this.k = k;

        for (int[] ints : relation) {
            ArrayList<Integer> l = this.relationMap.getOrDefault(ints[0], new ArrayList<>());
            l.add(ints[1]);
            this.relationMap.put(ints[0], l);
        }

        //        System.out.println(relationMap.keySet());
        //        for (Integer x : relationMap.keySet()) {
        //            System.out.println(x);
        //            for (Integer integer : relationMap.get(x)) {
        //                System.out.print(integer);
        //            }
        //            System.out.println();
        //        }
        dfs(0, 0);

        return this.ans;
    }

    public void dfs(int x, int i) {

        if (i == k) {
            if (x == this.n - 1) {
                this.ans++;
            }
            return;
        }
        ArrayList<Integer> l = this.relationMap.getOrDefault(x, new ArrayList<>());
        if (l.size() == 0) return;
        for (Integer v : l) {
            dfs(v, i + 1);
        }
    }

    public static void main(String[] args) {

        LeetcodeLPC07 ins = new LeetcodeLPC07();
        int[][] relation = new int[][] {{0, 1}, {1, 2}, {0, 2}};
        System.out.println(ins.numWays(3, relation, 2));
    }
}
