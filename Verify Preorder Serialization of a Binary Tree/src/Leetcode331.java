import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode331 {

    public boolean isValidSerialization(String s) {

        String[] preOrder = s.split(",");
        String pound = "#";
        Deque<String> stack = new ArrayDeque<>();
        for (String value : preOrder) {
            if (value.equals(pound)) {
                while (!stack.isEmpty() && stack.peekLast().equals(pound)) {
                    stack.pollLast();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pollLast();
                }
            }
            stack.offerLast(value);
        }
        return (stack.size() == 1 && stack.peekLast().equals(pound));
    }

    class Solution {
        public boolean isValidSerialization(String preorder) {
            int n = preorder.length();
            int i = 0;
            int slots = 1;
            while (i < n) {
                if (slots == 0) {
                    return false;
                }
                if (preorder.charAt(i) == ',') {
                    i++;
                } else if (preorder.charAt(i) == '#') {
                    slots--;
                    i++;
                } else {
                    // 读一个数字
                    while (i < n && preorder.charAt(i) != ',') {
                        i++;
                    }
                    slots++; // slots = slots - 1 + 2
                }
            }
            return slots == 0;
        }
    }

    /*
    作者：LeetCode-Solution
    链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/yan-zheng-er-cha-shu-de-qian-xu-xu-lie-h-jghn/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
