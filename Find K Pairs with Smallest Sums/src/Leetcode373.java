import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode373 {

    /*
    https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/solution/gong-shui-san-xie-duo-lu-gui-bing-yun-yo-pgw5/
     */
    // 多路归并
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

            List<List<Integer>> res = new ArrayList<>();
            int n = nums1.length;
            PriorityQueue<int[]> pq =
                    new PriorityQueue<>(Comparator.comparingInt(o -> nums1[o[0]] + nums2[o[1]]));
            for (int i = 0; i < Math.min(n, k); i++) {
                pq.offer(new int[] {i, 0});
            }
            while (res.size() < k && !pq.isEmpty()) {
                int[] front = pq.poll();
                res.add(
                        new ArrayList<>() {
                            {
                                add(nums1[front[0]]);
                                add(nums2[front[1]]);
                            }
                        });
                if (front[1] < nums2.length - 1) {
                    pq.offer(new int[] {front[0], front[1] + 1});
                }
            }
            return res;
        }
    }
}
