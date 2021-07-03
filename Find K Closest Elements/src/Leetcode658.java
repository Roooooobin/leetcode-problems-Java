import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leetcode658 {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<int[]> diffAndIdxList = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i) {
            int[] diffAndIdx = new int[2];
            diffAndIdx[0] = Math.abs(arr[i] - x);
            diffAndIdx[1] = i;
            diffAndIdxList.add(diffAndIdx);
        }

        diffAndIdxList.sort(
                (o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                });

        List<Integer> res = new ArrayList<>();
        //        if (k > arr.length) {
        //            k = arr.length;
        //        }
        for (int i = 0; i < k; ++i) {
            res.add(arr[diffAndIdxList.get(i)[1]]);
        }
        res.sort(Comparator.comparingInt(o -> o));

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 2, 4, 5};
        System.out.println(findClosestElements(arr, 2, 2));
    }
}
