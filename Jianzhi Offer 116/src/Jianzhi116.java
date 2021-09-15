public class Jianzhi116 {

    int[] par;

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        par = new int[n];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {

            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    combine(i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < par.length; i++) {
            if (par[i] == i) {
                res++;
            }
        }
        return res;
    }

    public int findRoot(int i) {
        int r = i;
        while (par[r] != r) {
            r = par[r];
        }
        while (par[i] != r) {
            int parX = par[i];
            par[i] = r;
            i = parX;
        }
        return r;
    }

    public void combine(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);
        if (x == y) {
            return;
        }
        par[y] = x;
    }
}
