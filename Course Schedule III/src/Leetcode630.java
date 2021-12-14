import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
https://leetcode-cn.com/problems/course-schedule-iii/solution/ke-cheng-biao-iii-by-leetcode-solution-yoyz/
 */
public class Leetcode630 {

    public int scheduleCourse(int[][] courses) {

        // sort by end time
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int total = 0;
        for (int[] course : courses) {
            int duration = course[0], endTime = course[1];
            // before endTime, add to pq
            if (total + duration <= endTime) {
                total += duration;
                pq.offer(duration);
                // the largest duration in the pq is larger than the current
            } else if (!pq.isEmpty() && pq.peek() > duration) {
                total -= (pq.poll() - duration);
                pq.offer(duration);
            }
        }
        return pq.size();
    }
}
