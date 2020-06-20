import java.util.LinkedList;
import java.util.Queue;

public class Leetcode225 {
    class MyStack {
        private Queue<Integer> stack = new LinkedList<>();

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            stack.offer(x);
            for (int i=1; i<stack.size(); ++i) {
                stack.offer(stack.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return stack.poll();
        }

        /** Get the top element. */
        public int top() {
            return stack.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
