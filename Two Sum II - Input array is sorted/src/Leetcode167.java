public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                break;
            }
            else if (sum < target) {
                ++l;
            }
            else --r;
        }
        return new int[]{l+1, r+1};
    }
}
