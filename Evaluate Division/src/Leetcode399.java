import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode399 {

    public double[] calcEquation(
            List<List<String>> equations, double[] values, List<List<String>> queries) {

        int n = queries.size();
        double[] res = new double[n];
        // 变量名映射为int
        HashMap<String, Integer> hash = new HashMap<>();
        int idx = 0;
        for (List<String> equation : equations) {
            for (String s : equation) {
                if (hash.containsKey(s)) {
                    continue;
                }
                hash.put(s, idx++);
            }
        }
        double[][] div = new double[idx][idx];
        for (double[] doubles : div) {
            Arrays.fill(doubles, -1);
        }
        for (int i = 0; i < equations.size(); i++) {
            int a = hash.get(equations.get(i).get(0)), b = hash.get(equations.get(i).get(1));
            div[a][b] = values[i];
            div[b][a] = 1.0 / values[i];
        }

        for (int k = 0; k < idx; k++) {
            for (int i = 0; i < idx; i++) {
                for (int j = 0; j < idx; j++) {
                    if (i == j) {
                        div[i][j] = 1;
                        continue;
                    }
                    if (div[i][k] != -1 && div[k][j] != -1) {
                        div[i][j] = div[i][k] * div[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < queries.size(); i++) {
            int a = hash.getOrDefault(queries.get(i).get(0), -1),
                    b = hash.getOrDefault(queries.get(i).get(1), -1);
            if (a == -1 || b == -1) {
                res[i] = -1.0;
            } else {
                res[i] = div[a][b];
            }
        }

        return res;
    }
}
