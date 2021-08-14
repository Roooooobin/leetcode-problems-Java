import java.util.HashSet;

public class Leetcode1583 {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {

        int[][] ratings = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            int rt = n - 1;
            for (int j = 0; j < preferences[i].length; j++) {
                ratings[i][preferences[i][j]] = rt--;
            }
        }

        HashSet<Integer> unhappy = new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
            for (int j = i + 1; j < pairs.length; j++) {
                int x = pairs[i][0], y = pairs[i][1];
                int u = pairs[j][0], v = pairs[j][1];
                judgeUnhappy(ratings, unhappy, x, y, u, v);
                judgeUnhappy(ratings, unhappy, x, y, v, u);
                judgeUnhappy(ratings, unhappy, y, x, u, v);
                judgeUnhappy(ratings, unhappy, y, x, v, u);
                judgeUnhappy(ratings, unhappy, u, v, x, y);
                judgeUnhappy(ratings, unhappy, u, v, y, x);
                judgeUnhappy(ratings, unhappy, v, u, x, y);
                judgeUnhappy(ratings, unhappy, v, u, y, x);
            }
        }
        return unhappy.size();
    }

    public void judgeUnhappy(
            int[][] ratings, HashSet<Integer> unhappy, int x, int y, int u, int v) {
        if (ratings[x][u] > ratings[x][y] && ratings[u][x] > ratings[u][v]) {
            unhappy.add(x);
            unhappy.add(u);
        }
    }

    class Solution {
        public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
            int[][] order = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    order[i][preferences[i][j]] = j;
                }
            }
            int[] match = new int[n];
            for (int[] pair : pairs) {
                int person0 = pair[0], person1 = pair[1];
                match[person0] = person1;
                match[person1] = person0;
            }
            int unhappyCount = 0;
            for (int x = 0; x < n; x++) {
                int y = match[x];
                int index = order[x][y];
                for (int i = 0; i < index; i++) {
                    int u = preferences[x][i];
                    int v = match[u];
                    if (order[u][x] < order[u][v]) {
                        unhappyCount++;
                        break;
                    }
                }
            }
            return unhappyCount;
        }
    }

    /*
    作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/count-unhappy-friends/solution/tong-ji-bu-kai-xin-de-peng-you-by-leetcode-solutio/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     */
}
