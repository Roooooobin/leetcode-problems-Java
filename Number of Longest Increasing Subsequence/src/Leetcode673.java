import java.util.TreeMap;

public class Leetcode673 {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int len = 0;
        int[] minEndForLen = new int[n + 1];
        minEndForLen[0] = nums[0];
        TreeMap<Integer, Integer>[] maps = new TreeMap[n + 1];
        for (int i = 0; i < n + 1; i++) {
            maps[i] = new TreeMap<>();
        }
        for (int num : nums) {
            if (minEndForLen[len] < num) {
                minEndForLen[++len] = num;
                int count = 0;
                for (Integer key : maps[len - 1].keySet()) {
                    if (num > key) {
                        count += maps[len - 1].get(key);
                    } else {
                        break;
                    }
                }
                maps[len].put(num, count);

            } else {
                int idx = lowerBound(minEndForLen, num, len);
                minEndForLen[idx] = num;
                int count = 0;
                if (idx != 0) {
                    for (Integer key : maps[idx - 1].keySet()) {
                        if (num > key) {
                            count += maps[idx - 1].get(key);
                        } else {
                            break;
                        }
                    }
                } else {
                    count = 1;
                }
                maps[idx].put(num, count + maps[idx].getOrDefault(num, 0));
            }
        }
        int res = 0;
        for (Integer k : maps[len].keySet()) {
            res += maps[len].get(k);
        }

        return res;
    }

    public int lowerBound(int[] a, int tar, int len) {

        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (a[mid] < tar) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1, 1, 2, 2, 2, 3, 3, 3};
        Leetcode673 ins = new Leetcode673();
        ins.findNumberOfLIS(arr);
    }
}
