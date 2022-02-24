public class Leetcode2179 {

    public class FenwickTree {

        private int[] tree;
        int n;

        public FenwickTree(int n) {

            this.n = n;
            this.tree = new int[n + 1];
        }

        public void update(int i, int x) {

            while (i <= n) {
                this.tree[i] += x;
                i += lowBit(i);
            }
        }

        public int query(int i) {

            int sum = 0;
            while (i > 0) {
                sum += this.tree[i];
                i -= lowBit(i);
            }
            return sum;
        }

        public int lowBit(int i) {
            return i & (-i);
        }
    }

    public long goodTriplets(int[] nums1, int[] nums2) {

        int[] a = new int[nums1.length];
        int[] hash = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            hash[nums1[i]] = i;
        }
        for (int i = 0; i < nums2.length; i++) {
            a[i] = hash[nums2[i]];
        }
        int n = a.length;
        FenwickTree fenwickTree = new FenwickTree(n);
        long res = 0L;
        for (int i = 1; i < n - 1; i++) {
            fenwickTree.update(a[i - 1] + 1, 1);
            long less = fenwickTree.query(a[i]);
            res += less * (n - a[i] - 1 - (i - less));
        }
        return res;
    }
}
