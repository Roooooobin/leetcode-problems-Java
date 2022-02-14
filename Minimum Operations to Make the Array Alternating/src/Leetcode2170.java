import java.util.HashMap;
import java.util.HashSet;

public class Leetcode2170 {

    public int minimumOperations(int[] nums) {

        int n = nums.length;
        HashMap<Integer, Integer> oddPosition = new HashMap<>();
        HashMap<Integer, Integer> evenPosition = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                oddPosition.put(nums[i], oddPosition.getOrDefault(nums[i], 0) + 1);
            } else {
                evenPosition.put(nums[i], evenPosition.getOrDefault(nums[i], 0) + 1);
            }
        }
        int oddMax = 0;
        int oddSecondMax = 0;
        for (int key : oddPosition.keySet()) {
            int v = oddPosition.get(key);
            if (v > oddMax) {
                oddSecondMax = oddMax;
                oddMax = v;
            } else if (v < oddMax && v > oddSecondMax) {
                oddSecondMax = v;
            }
        }
        HashSet<Integer> oddSets = new HashSet<>();
        for (int key : oddPosition.keySet()) {
            int v = oddPosition.get(key);
            if (v == oddMax) {
                oddSets.add(key);
            }
        }

        int evenMax = 0;
        int evenSecondMax = 0;
        for (int key : evenPosition.keySet()) {
            int v = evenPosition.get(key);
            if (v > evenMax) {
                evenSecondMax = evenMax;
                evenMax = v;
            } else if (v < evenMax && v > evenSecondMax) {
                evenSecondMax = v;
            }
        }
        HashSet<Integer> evenSets = new HashSet<>();
        for (int key : evenPosition.keySet()) {
            int v = evenPosition.get(key);
            if (v == evenMax) {
                evenSets.add(key);
            }
        }

        System.out.println(evenMax);
        System.out.println(evenSecondMax);
        System.out.println(oddMax);
        System.out.println(oddSecondMax);

        if (oddSets.size() == 1 && evenSets.size() == 1) {
            int[] a = new int[1];
            int[] b = new int[1];
            for (Integer x : oddSets) {
                a[0] = x;
            }
            for (Integer x : evenSets) {
                b[0] = x;
            }
            if (a[0] == b[0]) {
                return Math.min(n - oddMax - evenSecondMax, n - oddSecondMax - evenMax);
            } else {
                return n - oddMax - evenMax;
            }
        } else {
            return n - oddMax - evenMax;
        }
    }

    public static void main(String[] args) {
        Leetcode2170 ins = new Leetcode2170();
        int res = ins.minimumOperations(new int[] {1, 2, 2, 2, 2});
        System.out.println(res);
    }
}
