import java.util.ArrayList;
import java.util.List;

/*
https://leetcode-cn.com/problems/expression-add-operators/solution/gei-biao-da-shi-tian-jia-yun-suan-fu-by-leetcode/
 */
public class Leetcode282 {

    List<String> res;
    String num;
    int target;

    public List<String> addOperators(String num_, int target_) {

        res = new ArrayList<>();
        num = num_;
        target = target_;
        if (num == null || num.length() == 0) {
            return res;
        }
        doAddOperators("", 0, 0, 0);
        return res;
    }

    public void doAddOperators(String path, int idx, long eval, long mul) {
        if (idx == num.length()) {
            if (eval == target) {
                res.add(path);
            }
            return;
        }
        for (int i = idx; i < num.length(); i++) {
            if (i != idx && num.charAt(idx) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(idx, i + 1));
            if (idx == 0) {
                doAddOperators(path + cur, i + 1, cur, cur);
            } else {
                doAddOperators(path + "+" + cur, i + 1, eval + cur, cur);
                doAddOperators(path + "-" + cur, i + 1, eval - cur, -cur);
                doAddOperators(path + "*" + cur, i + 1, eval + (cur - 1) * mul, mul * cur);
            }
        }
    }
}
