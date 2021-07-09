public class Leetcode1710 {

    // Boyer-Moore投票算法
    public int majorityElement(int[] nums) {

        int candidate = -1, cnt = 0;
        for (int num : nums) {
            // 如果已经被抵消完了，更新候选
            if (cnt == 0) {
                candidate = num;
            }
            // 如果当前值等于候选，cnt++，否则抵消
            if (num == candidate) {
                ++cnt;
            } else {
                --cnt;
            }
        }

        // 最后验证一遍候选
        cnt = 0;
        for (int num : nums) {
            cnt += (num == candidate) ? 1 : 0;
        }
        return cnt * 2 > nums.length ? candidate : -1;
    }
}
