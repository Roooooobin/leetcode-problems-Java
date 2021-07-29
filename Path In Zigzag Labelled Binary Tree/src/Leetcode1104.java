import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode1104 {
    public List<Integer> pathInZigZagTree(int label) {

        ArrayList<Integer> res = new ArrayList<>();
        if (label == 1) {
            res.add(1);
            return res;
        }
        int level = 2;
        for (; ; ++level) {
            int pre = (1 << (level - 1)) - 1;
            int cur = (1 << level) - 1;
            if (pre <= label && label <= cur) {
                break;
            }
        }
        while (level > 0) {
            res.add(label);
            int pre = (1 << (level - 1)) - 1;
            int cur = (1 << level) - 1;
            if (level % 2 == 1) {
                // 上一个节点是从左往右的第left棵子树
                int left = (label - pre - 1) / 2 + 1;
                label = pre - left + 1;
            } else {
                int left = (cur - label) / 2 + 1;
                label = pre / 2 + left;
            }
            --level;
        }
        Collections.reverse(res);
        return res;
    }
}
