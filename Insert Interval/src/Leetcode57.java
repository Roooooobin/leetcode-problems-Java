import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int idx = 0;
        List<int[]> lists = new LinkedList<>();
        while(idx < n && intervals[idx][1] < newInterval[0]){
            lists.add(intervals[idx++]);
        }
        while(idx < n && intervals[idx][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            ++idx;
        }
        lists.add(newInterval);
        while(idx < n){
            lists.add(intervals[idx]);
            ++idx;
        }
        return lists.toArray(new int[lists.size()][2]);
    }

    public static void main(String[] args) {
        Leetcode57 leetcode57 = new Leetcode57();

    }
}
