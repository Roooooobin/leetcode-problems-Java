import java.util.Stack;

public class Leetcode901 {
    class StockSpanner {
        private Stack<int[]> stack = new Stack<>();

        public StockSpanner() {
        }

        // [0]保存价格，[1]保存当前价格的span
        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }
            stack.push(new int[]{price, span});
            return span;
        }
    }
}
