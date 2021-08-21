public class Leetcode781 {

    public int numRabbits(int[] a) {

        int res = 0;
        int[] countMap = new int[1000];
        for (int x : a) {
            countMap[x]++;
        }
        for (int i = 0; i < 1000; i++) {
            if (countMap[i] > 0) {
                int group = i + 1; // 一组相同颜色兔子的个数
                // 每group个兔子可以是一个颜色，算出组数然后相乘
                res += (countMap[i] / group + 1 - ((countMap[i] % group == 0) ? 1 : 0)) * group;
            }
        }
        return res;
    }
}
