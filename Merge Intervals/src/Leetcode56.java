import java.util.*;

public class Leetcode56 {

//    public static int[][] merge(int[][] intervals) {
//        int n = intervals.length;
//        if(n == 0 || n == 1) return intervals;
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        List<List<Integer>> lists = new ArrayList<>();
//        int curMin = intervals[0][0], curMax = intervals[0][1];
//        for(int i=1; i<n; ++i){
//            if(intervals[i][0] > curMax){
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(curMin);
//                list.add(curMax);
//                lists.add(list);
//                curMin = intervals[i][0];
//                curMax = intervals[i][1];
//            }
//            else{
//                curMax = Math.max(curMax, intervals[i][1]);
//            }
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(curMin);
//        list.add(curMax);
//        lists.add(list);
//        System.out.println(lists);
//        int count = lists.size();
//        int[][] ans = new int[count][2];
//        for(int i=0; i<count; ++i){
//            ans[i][0] = lists.get(i).get(0);
//            ans[i][1] = lists.get(i).get(1);
//        }
//        return ans;
//    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 0 || n == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> ans = new LinkedList<>();
        int curMin = intervals[0][0], curMax = intervals[0][1];
        for(int[] interval: intervals){
            if(interval[0] > curMax){
                ans.add(new int[]{curMin, curMax});
                curMin = interval[0];
                curMax = interval[1];
            }
            else{
                curMax = Math.max(curMax, interval[1]);
            }
        }
        ans.add(new int[]{curMin, curMax});
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {9, 12}, {9, 11}, {2,6}, {8,10}, {15,18}};
        int[][] ans = merge(intervals);
        for(int i=0; i<ans.length; ++i){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
