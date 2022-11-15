package temp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: LockDemo
 * @Author: elon
 * @CreateDate: 2022/11/9 23:26
 * @Description:
 */
class LockDemo {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    private String data = null;

    private String read() {
        readLock.lock();
        String cache = null;
        try {
            cache = data;
        } finally {
            readLock.unlock();
        }
        return cache;
    }

    private void write(String data) {
        writeLock.lock();
        try {
            processData(data);
        } finally {
            writeLock.unlock();
        }
    }

    private void processData(String data) {
        this.data = data;
        System.out.println(data);
    }

    public static void main(String[] args) {
    }

    static class ProduceDemo {
        private Lock lock = new ReentrantLock();
        private Condition notEmpty = lock.newCondition();
        private int count = 0;
        private Object[] data = new Object[10];

        public Object take() throws InterruptedException {
            lock.lockInterruptibly();
            try {
                while (count == 0) {
                    notEmpty.await();
                }
                count--;
                return data[count];
            } finally {
                lock.unlock();
            }
        }

        private boolean isFull = false;

        public void put(Object obj) {
            if (isFull) return;
            data[count] = obj;
            count++;
            notEmpty.signalAll();
        }

    }
}
