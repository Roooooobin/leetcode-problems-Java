import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OptimalUtilization {
    public static List<int[]> getPairs(int[][] a, int[][] b, int target) {
        Arrays.sort(a, Comparator.comparingInt(x -> x[1]));
        Arrays.sort(b, Comparator.comparingInt(x -> x[1]));
        List<int[]> ans = new ArrayList<>();
        int n = a.length;
        int m = b.length;
        int i = 0, j = m-1;
        int max = Integer.MIN_VALUE;
        while (i < n && j >= 0) {
            int sum = a[i][1] + b[j][1];
            // 比target大，要减小和，右指针向左移
            if (sum > target) {
                --j;
            }
            else {
                if (max <= sum) {
                    // 如果找到了更大的sum，那么前面存储的都无效了，更新最大值并清除
                    if (max < sum) {
                        max = sum;
                        ans.clear();
                    }
                    ans.add(new int[]{a[i][0], b[j][0]});
                    int idx = j-1;
                    // 重复值都加入
                    while (idx >= 0 && b[idx][1] == b[idx+1][1]) {
                        ans.add(new int[]{a[i][0], b[idx--][0]});
                    }
                }
                ++i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] a1 = {{1, 5}, {2, 5}};
        int[][] b1 = {{1, 5}, {2, 5}};
        List<int[]> ans1 = getPairs(a1, b1, 10);
        for (int[] arr : ans1) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
