import java.util.ArrayList;
import java.util.List;

public class BiweekContest72 {

    class Solution1 {
        public int countPairs(int[] nums, int k) {

            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((i * j) % k == 0 && nums[i] == nums[j]) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

    //    class Solution2:
    //    def sumOfThree(self, num: int) -> List[int]:
    //            if num % 3 != 0:
    //            return []
    //            else:
    //            return [num//3-1, num//3, num//3+1]

    class Solution3 {
        public List<Long> maximumEvenSplit(long finalSum) {

            List<Long> res = new ArrayList<>();
            if (finalSum % 2 == 1) {
                return res;
            }
            long tmp = finalSum;
            for (long i = 2; i <= finalSum; i += 2) {
                if (i * 2 + 2 > tmp) {
                    res.add(tmp);
                    break;
                } else {
                    res.add(i);
                }
                tmp -= i;
            }
            return res;
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int[] pos = new int[n];
        for (int i = 0; i < nums2.length; i++) {
            pos[nums2[i]] = i;
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = pos[nums1[i]];
        }
        int[] greaterCount = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[i]) {
                    greaterCount[i]++;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[i]) {
                    continue;
                }
                res += greaterCount[j];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        BiweekContest72 ins = new BiweekContest72();
        int[] nums1 = new int[] {13, 14, 10, 2, 12, 3, 9, 11, 15, 8, 4, 7, 0, 6, 5, 1};
        int[] nums2 = new int[] {8, 7, 9, 5, 6, 14, 15, 10, 2, 11, 4, 13, 3, 12, 1, 0};
        ins.goodTriplets(nums1, nums2);
    }
    /*
    [13,14,10,2,12,3,9,11,15,8,4,7,0,6,5,1]
    [8,7,9,5,6,14,15,10,2,11,4,13,3,12,1,0]
     */
}
