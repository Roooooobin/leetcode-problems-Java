import java.util.Arrays;

public class Leetcode927 {

    public int[] threeEqualParts(int[] arr) {

        int[] impossible = new int[] {-1, -1};
        // 计算1的个数
        int countOne = 0;
        for (int x : arr) {
            countOne += x;
        }
        // 每部分都有均等的1，如果1的总数不能整除3那么一定无解
        if (countOne % 3 != 0) {
            return impossible;
        }
        // 每部分都有 count1 / 3 个1
        int oneInEachPart = countOne / 3;
        if (oneInEachPart == 0) {
            return new int[] {0, arr.length - 1};
        }
        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
        int curCountOfOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                ++curCountOfOne;
                if (curCountOfOne == 1) i1 = i;
                if (curCountOfOne == oneInEachPart) j1 = i;
                if (curCountOfOne == oneInEachPart + 1) i2 = i;
                if (curCountOfOne == 2 * oneInEachPart) j2 = i;
                if (curCountOfOne == 2 * oneInEachPart + 1) i3 = i;
                if (curCountOfOne == 3 * oneInEachPart) j3 = i;
            }
        }

        int[] part1 = Arrays.copyOfRange(arr, i1, j1 + 1);
        int[] part2 = Arrays.copyOfRange(arr, i2, j2 + 1);
        int[] part3 = Arrays.copyOfRange(arr, i3, j3 + 1);
        if (!Arrays.equals(part1, part2)) return impossible;
        if (!Arrays.equals(part1, part3)) return impossible;

        // x, y, z表示每部分的后缀0
        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = arr.length - j3 - 1;
        // 后缀0个数必须相等
        if (x < z || y < z) return impossible;

        return new int[] {j1 + z, j2 + z + 1};
    }
}
