import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Leetcode284 {

    class PeekingIterator implements Iterator<Integer> {

        Deque<Integer> list = new ArrayDeque<>();

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while (iterator.hasNext()) {
                list.offerLast(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return list.peekFirst();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return list.pollFirst();
        }

        @Override
        public boolean hasNext() {
            return !list.isEmpty();
        }
    }
}
