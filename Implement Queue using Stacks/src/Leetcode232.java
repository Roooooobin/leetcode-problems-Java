import java.util.Stack;

public class Leetcode232 {
    class MyQueue {

        private Stack<Integer> input = new Stack<>();
        private Stack<Integer> output = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            int x = peek();
            return output.pop();
        }

        public int peek() {
            if (output.empty()) {
                while (!input.empty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.empty() && output.empty();
        }
    }
}
