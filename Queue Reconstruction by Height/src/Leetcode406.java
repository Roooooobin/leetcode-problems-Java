import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode406 {
    public static int[][] reconstructQueue(int[][] people) {
        if (people.length == 0) return new int[0][0];
        Arrays.sort(people, (n1, n2) -> (n2[0] == n1[0])?  n1[1] - n2[1] : n2[0] - n1[0]);
        LinkedList<int[]> lists = new LinkedList<>();
        lists.add(people[0]);
        for (int i=1; i<people.length; ++i) {
//            System.out.println(Arrays.toString(people[i]));
            int idx = 0;
            int cnt = 0;
            for (int[] p : lists) {
                if (cnt == people[i][1]) {
                    break;
                }
                if (p[0] >= people[i][0]) {
                    cnt++;
                }
                idx++;
            }
            lists.add(idx, people[i]);
        }
        return lists.toArray(new int[lists.size()][2]);
    }

    static class betterSolution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, (n1, n2) -> (n2[0] == n1[0])?  n1[1] - n2[1] : n2[0] - n1[0]);
            List<int[]> res = new LinkedList<>();
            for(int[] p : people)  res.add(p[1], p);
            return res.toArray(new int[people.length][2]);
        }
    }

    public static void main(String[] args) {
        int[][] people = {{5, 2}, {5, 0}, {7, 1}, {7, 0}, {6, 1}, {4, 4}};
        int[][] ans = reconstructQueue(people);
        System.out.println(Arrays.deepToString(ans));
    }
}
