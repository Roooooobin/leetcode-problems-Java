import java.util.PriorityQueue;

public class Leetcode1675 {

    // WA
    //    public int minimumDeviation(int[] a) {
    //
    //        int n = a.length;
    //        Arrays.sort(a);
    //        if (a[n - 1] % 2 == 1) {
    //            int devMin = -1;
    //            if (a[0] % 2 == 0) {
    //                return a[n - 1] - a[0];
    //            } else {
    //                // find even number
    //                int i;
    //                for (i = 1; i < n - 1; i++) {
    //                    if (a[i] % 2 == 0) {
    //                        break;
    //                    }
    //                }
    //                if (i == n - 1) {
    //                    return Math.min(a[n - 1] - a[0], Math.abs(a[n - 1] - a[0] * 2));
    //                }
    //                // 只用比最小的那个奇数
    //                if (a[0] * 2 <= a[i]) {
    //                    return a[n - 1] - a[0] * 2;
    //                }
    //                if (a[0] * 2 < a[n - 1]) {
    //                    return a[n - 1] - a[i];
    //                } else {
    //                    return Math.min(a[n - 1] - a[0], a[0] * 2 - a[i]);
    //                }
    //            }
    //        } else {
    //            a[n - 1] /= 2;
    //            return minimumDeviation(a);
    //        }
    //    }

    /*
    https://leetcode-cn.com/problems/minimize-deviation-in-array/solution/si-wei-ti-by-happysnaker-1ds9/
     */
    public int minimumDeviation(int[] nums) {
        int min = 0x3f3f3f3f;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            if ((num & 1) == 1) {
                num = num << 1;
            }
            pq.offer(num);
            min = Math.min(min, num);
        }
        int res = pq.peek() - min;
        while (!pq.isEmpty() && (pq.peek() & 1) == 0) {
            int temp = pq.peek() >> 1;
            pq.poll();
            pq.offer(temp);
            min = Math.min(min, temp);
            res = Math.min(res, pq.peek() - min);
        }
        return res;
    }

    public static void main(String[] args) {

        Leetcode1675 ins = new Leetcode1675();
        System.out.println(ins.minimumDeviation(new int[] {10, 4, 3, 5}));
    }
}
