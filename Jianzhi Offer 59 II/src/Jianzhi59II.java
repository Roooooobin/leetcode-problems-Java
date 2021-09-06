import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Jianzhi59II {
    class MaxQueue {

        Queue<Integer> queue;
        Deque<Integer> maxQueue;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            maxQueue = new ArrayDeque<>();
        }

        public int max_value() {
            if (maxQueue.isEmpty()) {
                return -1;
            }
            return maxQueue.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
                maxQueue.pollLast();
            }
            maxQueue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int front = queue.poll();
            if (!maxQueue.isEmpty() && maxQueue.peek() == front) {
                maxQueue.poll();
            }
            return front;
        }
    }
}
