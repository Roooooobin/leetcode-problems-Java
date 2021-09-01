import java.util.concurrent.Semaphore;

public class Leetcode1115 {

    class FooBar {
        private int n;
        private Semaphore semaphoreFoo = new Semaphore(0);
        private Semaphore semaphoreBar = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                if (i != 0) {
                    semaphoreFoo.acquire();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                semaphoreBar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                semaphoreBar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                semaphoreFoo.release();
            }
        }
    }
}
