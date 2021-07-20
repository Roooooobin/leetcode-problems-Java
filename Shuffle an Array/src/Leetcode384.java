import java.util.Random;

public class Leetcode384 {

    class Solution {

        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {

            if (this.nums == null) {
                return null;
            }
            int[] res = this.nums.clone();
            for (int i = 1; i < res.length; ++i) {
                int j = random.nextInt(i + 1);
                swap(res, i, j);
            }
            return res;
        }

        private void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
