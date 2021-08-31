import java.util.concurrent.Semaphore;

public class Leetcode1114 {

    class Foo {

        private Semaphore two, three;

        public Foo() {

            two = new Semaphore(0);
            three = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            two.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            two.acquire();
            printSecond.run();
            three.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            three.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
