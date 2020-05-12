import java.util.Stack;

public class Leetcode155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MinStack {
    private Stack<Integer> stack = new Stack<>();;
    private Stack<Integer> minStack = new Stack<>();    // always store minimum on top

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}