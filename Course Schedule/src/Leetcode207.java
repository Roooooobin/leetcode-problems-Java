import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCourseCount = new int[numCourses];
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
            ++cnt;
            if (coursePostCourse.containsKey(node)) {
                for (int x: coursePostCourse.get(node)) {
                    preCourseCount[x]--;
                    if (preCourseCount[x] == 0) {
                        q.offer(x);
                    }
                }
            }
        }
        return cnt == numCourses;
    }
}
