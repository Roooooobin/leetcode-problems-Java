import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1001 {

    //    class Solution {
    //        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
    //
    //            int[] res = new int[queries.length];
    //            int[] row = new int[n];
    //            int[] col = new int[n];
    //            int[] diag = new int[2 * n];
    //            int[] antiDiag = new int[2 * n];
    //            HashSet<Integer> open = new HashSet<>();
    //            // diag: n - (x - y)
    //            for (int[] lamp : lamps) {
    //                int x = lamp[0], y = lamp[1];
    //                if (open.contains(x * n + y)) {
    //                    continue;
    //                }
    //                open.add(x * n + y);
    //                row[x]++;
    //                col[y]++;
    //                diag[n - x + y - 1]++;
    //                antiDiag[x + y]++;
    //            }
    //            HashSet<Integer> out = new HashSet<>();
    //            int idx = 0;
    //            int[][] directions =
    //                    new int[][] {
    //                        {0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1},
    // {1, -1}
    //                    };
    //            for (int[] query : queries) {
    //                int qx = query[0], qy = query[1];
    //                if ((row[qx] > 0
    //                        || col[qy] > 0
    //                        || diag[n - qx + qy - 1] > 0
    //                        || antiDiag[qx + qy] > 0)) {
    //                    res[idx++] = 1;
    //                } else {
    //                    res[idx++] = 0;
    //                    continue;
    //                }
    //                // turn off
    //                for (int[] direction : directions) {
    //                    int nx = qx + direction[0], ny = qy + direction[1];
    //                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
    //                        if (open.contains(nx * n + ny)) {
    //                            open.remove(nx * n + ny);
    //                            row[nx]--;
    //                            col[ny]--;
    //                            diag[n - nx + ny - 1]--;
    //                            antiDiag[nx + ny]--;
    //                        }
    //                    }
    //                }
    //            }
    //            return res;
    //        }
    //    }

    class Solution {
        public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
            Map<Integer, Integer> row = new HashMap<>();
            Map<Integer, Integer> col = new HashMap<>();
            Map<Integer, Integer> diag = new HashMap<>();
            Map<Integer, Integer> antiDiag = new HashMap<>();
            Set<Long> open = new HashSet<>();
            for (int[] lamp : lamps) {
                int x = lamp[0], y = lamp[1];
                if (!open.add(hash(x, y))) {
                    continue;
                }
                row.put(x, row.getOrDefault(x, 0) + 1);
                col.put(y, col.getOrDefault(y, 0) + 1);
                diag.put(x - y, diag.getOrDefault(x - y, 0) + 1);
                antiDiag.put(x + y, antiDiag.getOrDefault(x + y, 0) + 1);
            }
            int[] ret = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int r = queries[i][0], c = queries[i][1];
                if (row.getOrDefault(r, 0) > 0) {
                    ret[i] = 1;
                } else if (col.getOrDefault(c, 0) > 0) {
                    ret[i] = 1;
                } else if (diag.getOrDefault(r - c, 0) > 0) {
                    ret[i] = 1;
                } else if (antiDiag.getOrDefault(r + c, 0) > 0) {
                    ret[i] = 1;
                }
                for (int x = r - 1; x <= r + 1; x++) {
                    for (int y = c - 1; y <= c + 1; y++) {
                        if (x < 0 || y < 0 || x >= n || y >= n) {
                            continue;
                        }
                        if (open.remove(hash(x, y))) {
                            row.put(x, row.get(x) - 1);
                            if (row.get(x) == 0) {
                                row.remove(x);
                            }
                            col.put(y, col.get(y) - 1);
                            if (col.get(y) == 0) {
                                col.remove(y);
                            }
                            diag.put(x - y, diag.get(x - y) - 1);
                            if (diag.get(x - y) == 0) {
                                diag.remove(x - y);
                            }
                            antiDiag.put(x + y, antiDiag.get(x + y) - 1);
                            if (antiDiag.get(x + y) == 0) {
                                antiDiag.remove(x + y);
                            }
                        }
                    }
                }
            }
            return ret;
        }

        public long hash(int x, int y) {
            return (long) x + ((long) y << 32);
        }
    }
}
