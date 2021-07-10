import java.util.Arrays;

public class Leetcode274_redo {

    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int res = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > res) {
            ++res;
            --i;
        }
        return res;
    }

    // 计数排序
    public int hIndex(int[] citations) {

        int n = citations.length, total = 0;
        int[] counter = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                counter[n]++;
            } else {
                counter[c]++;
            }
        }
        for (int i = n; i >= 0; --i) {
            total += counter[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}
