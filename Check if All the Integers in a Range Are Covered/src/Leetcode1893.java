public class Leetcode1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {

        // 差分数组+前缀和
        int[] diff = new int[52];
        for (int[] range : ranges) {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }

        int prefixSum = 0;
        for (int i = 1; i <= 50; ++i) {
            prefixSum += diff[i];
            if (i >= left && i <= right && prefixSum <= 0) {
                return false;
            }
        }
        return true;
    }
}
