import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode295 {

    class MedianFinder {

        /** initialize your data structure here. */
        private Queue<Integer> smallHalf, largeHalf;

        public MedianFinder() {
            // 降序排列，保存小一半
            smallHalf = new PriorityQueue<>(Collections.reverseOrder());
            // 默认是升序排列，保存大一半
            largeHalf = new PriorityQueue<>();
        }

        public void addNum(int num) {
            largeHalf.add(num);
            smallHalf.add(largeHalf.poll());
            if (largeHalf.size() < smallHalf.size()) {
                largeHalf.add(smallHalf.poll());
            }
        }

        public double findMedian() {
            if (largeHalf.size() > smallHalf.size()) {
                return largeHalf.peek();
            } else {
                return (largeHalf.peek() + smallHalf.peek()) / 2.0;
            }
        }
    }
}
