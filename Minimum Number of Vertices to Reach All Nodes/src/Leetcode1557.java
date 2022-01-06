import java.util.ArrayList;
import java.util.List;

public class Leetcode1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] degree = new int[n];
        for (List<Integer> edge : edges) {
            degree[edge.get(1)]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
