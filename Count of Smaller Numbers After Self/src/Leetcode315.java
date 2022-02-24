import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Leetcode315 {

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

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        // avoid duplicate
        HashMap<Integer, Integer> num2RankMap = new HashMap<>();
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n);
        Arrays.sort(tmp);
        int rank = 1;
        for (int v : tmp) {
            if (num2RankMap.containsKey(v)) {
                continue;
            }
            num2RankMap.put(v, rank++);
        }
        FenwickTree fenwickTree = new FenwickTree(rank);
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            rank = num2RankMap.get(nums[i]);
            int smallerCount = fenwickTree.query(rank - 1);
            fenwickTree.update(rank, 1);
            res.addFirst(smallerCount);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode315 ins = new Leetcode315();
        System.out.println(ins.countSmaller(new int[] {5, 2, 6, 1, 1, 2}));
    }
}
