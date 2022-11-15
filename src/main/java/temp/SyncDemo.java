package temp;

/**
 * @ClassName: SyncDemo
 * @Author: elon
 * @CreateDate: 2022/11/10 01:25
 * @Description:
 */
public class SyncDemo {

    public static synchronized void syncStatic() {}

    public synchronized void syncMethod() {}

    public void method() {
        //obj/Name.class
        synchronized(this) {}
    }

    public static void main(String[] args) {
        SyncStack stack = new SyncStack();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                char c = (char) (i + 100);
                stack.push(c);
                System.out.println(">>>>>>> push : " + c);
            }
        });

        Runnable consumerRunnable = () -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                char c = stack.pop();
                System.out.println("<<<<<<<<<< pop: " + c);
            }
        };

        producer.start();
        for (int i = 0; i < 10; i++) {
            Thread consumer = new Thread(consumerRunnable);
            consumer.start();
        }
    }
}
