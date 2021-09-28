public class Leetcode922 {

    public static void main(String[] args) {
        int[] a = new int[] {4, 1, 1, 0, 1, 0};
        Leetcode922 ins = new Leetcode922();
        ins.sortArrayByParityII(a);
    }

    public int[] sortArrayByParityII(int[] nums) {

        int i = 0, j = nums.length - 1;
        while (i < nums.length && j > 0) {
            while (i < nums.length && (nums[i] & 1) == 0) {
                i += 2;
            }
            while (j > 0 && (nums[j] & 1) == 1) {
                j -= 2;
            }
            if (i >= nums.length || j <= 0) {
                break;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i += 2;
            j -= 2;
        }
        return nums;
    }
}
