public class Jianzhi33 {

    public boolean verifyPostorder(int[] postorder) {

        int n = postorder.length;
        if (n < 2) {
            return true;
        }
        return doVerify(postorder, 0, n - 1);
    }

    public boolean doVerify(int[] post, int l, int r) {

        if (l >= r) {
            return true;
        }
        int root = post[r];
        int k = l;
        for (; k < r; k++) {
            if (post[k] > root) {
                break;
            }
        }
        for (int i = k; i < r; i++) {
            if (post[i] < root) {
                return false;
            }
        }
        if (!doVerify(post, l, k - 1)) {
            return false;
        }
        if (!doVerify(post, k, r - 1)) {
            return false;
        }

        return true;
    }
}
