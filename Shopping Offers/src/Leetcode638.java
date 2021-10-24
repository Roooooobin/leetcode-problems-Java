import java.util.ArrayList;
import java.util.List;

public class Leetcode638 {

    int res = 0x3f3f3f3f;
    List<Integer> price;
    List<List<Integer>> special;
    List<Integer> needs;
    int n_special;

    public void dfs(int idx, int cur, ArrayList<Integer> curList) {

        if (cur > res) {
            return;
        }
        boolean successFlag = true;
        for (int i = 0; i < needs.size(); i++) {
            if (!curList.get(i).equals(needs.get(i))) {
                successFlag = false;
                break;
            }
        }
        if (successFlag) {
            res = Math.min(res, cur);
        }

        for (int i = idx; i < n_special; i++) {
            ArrayList<Integer> nextList = new ArrayList<>();
            boolean flag = true;
            for (int j = 0; j < needs.size(); j++) {
                if (curList.get(j) + special.get(i).get(j) <= needs.get(j)) {
                    nextList.add(curList.get(j) + special.get(i).get(j));
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cur += special.get(i).get(needs.size());
                dfs(i, cur, nextList);
                cur -= special.get(i).get(needs.size());
            }
        }
    }

    public int shoppingOffers(
            List<Integer> price_, List<List<Integer>> special_, List<Integer> needs_) {

        price = price_;
        special = special_;
        needs = needs_;
        int n = price.size();
        for (int i = 0; i < price.size(); i++) {
            int[] a = new int[n + 1];
            a[n] = price.get(i);
            a[i] = 1;
            ArrayList<Integer> l = new ArrayList<>();
            for (int x : a) {
                l.add(x);
            }
            special.add(l);
        }
        n_special = special.size();
        ArrayList<Integer> initList = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            initList.add(0);
        }
        dfs(0, 0, initList);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(2);
        prices.add(5);
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(3);
        l1.add(0);
        l1.add(5);
        List<List<Integer>> specials = new ArrayList<>();
        specials.add(l1);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(10);
        specials.add(l2);
        ArrayList<Integer> need = new ArrayList<>();
        need.add(3);
        need.add(2);
        Leetcode638 ins = new Leetcode638();
        ins.shoppingOffers(prices, specials, need);
    }
}
