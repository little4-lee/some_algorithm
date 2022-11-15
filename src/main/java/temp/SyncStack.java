package temp;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: SyncStack
 * @Author: elon
 * @CreateDate: 2022/11/10 11:41
 * @Description:
 */
class SyncStack {
    private int index = 0;
    private final char[] data = new char[10];

    public synchronized char pop() {
        while (index == 0) {
            try {
                System.out.println("<<<<<<<<<< pop waiting ");
                //已经获得monitor的线程，让出monitor的使用权，进入wait队列
                //
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //notify不会立即释放monitor，synchronized内方法执行完后，monitor才会真正释放
        this.notifyAll();
        index--;
        return data[index];
    }

    public synchronized void push(char c) {
        while (index == data.length) {
            try {
                System.out.println(">>>>>>> push waiting ");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        data[index] = c;
        index++;
    }

    private void foo() {
        synchronized (this) {
            System.out.println("this is test");
        }
    }

    private void testAtomic() {
        AtomicInteger integer = new AtomicInteger(1);
        int increace = integer.incrementAndGet();
        System.out.println(increace);
    }
}
