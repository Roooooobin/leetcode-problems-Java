public class FenwickTree {

    //    https://www.acwing.com/blog/content/80/

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

    public static void main(String[] args) {

        int[] a = new int[] {3, 2, 1, 4};
        FenwickTree ft = new FenwickTree(a.length);
        for (int i = 0; i < a.length; i++) {
            ft.update(i + 1, a[i]);
        }
        System.out.println(ft.query(3));
        System.out.println(ft.query(4) - ft.query(2));
    }
}
