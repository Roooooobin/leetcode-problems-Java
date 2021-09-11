public class Leetcode678 {

    public boolean checkValidString(String s) {

        int l = 0, r = 0, star = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
            }
            if (c == ')') {
                r++;
                if (r > l + star) {
                    flag = false;
                    break;
                }
            }
            if (c == '*') {
                star++;
            }
        }
        if (!flag) {
            return false;
        }

        l = 0;
        r = 0;
        star = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                r++;
            }
            if (c == '(') {
                l++;
                if (l > r + star) {
                    flag = false;
                    break;
                }
            }
            if (c == '*') {
                star++;
            }
        }
        return flag;
    }

    // 左括号可能的最小值和最大值
    public boolean checkValidString2(String s) {
        char[] chars = s.toCharArray();
        int low = 0, high = 0;
        for (char c : chars) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == '*') {
                low--;
                high++;
            } else {
                low--;
                high--;
            }
            if (high < 0) return false; // 这个判断要及时，不能把后面的一起算进来，前面不行了就 false
            low = Math.max(0, low);
        }
        return low == 0;
    }
}
