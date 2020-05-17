import javafx.beans.binding.IntegerBinding;

import java.util.*;

public class Leetcode210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] preCourseCount = new int[numCourses];
        int[] order = new int[numCourses];
        HashMap<Integer, LinkedList<Integer>> coursePostCourse = new HashMap<>();
        for (int[] pres: prerequisites) {
            preCourseCount[pres[0]]++;
            if (!coursePostCourse.containsKey(pres[1])) {
                coursePostCourse.put(pres[1], new LinkedList<>());
            }
            coursePostCourse.get(pres[1]).offer(pres[0]);
        }
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<numCourses; ++i) {
            if (preCourseCount[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.remove();
            order[cnt++] = node;
            if (coursePostCourse.containsKey(node)) {
                for (int x: coursePostCourse.get(node)) {
                    preCourseCount[x]--;
                    if (preCourseCount[x] == 0) {
                        q.offer(x);
                    }
                }
            }
        }
        if (cnt == numCourses) {
            return order;
        }
        else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int[] ans = findOrder(4, new int[][]{{1,0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.println(Arrays.toString(ans));
    }
}
