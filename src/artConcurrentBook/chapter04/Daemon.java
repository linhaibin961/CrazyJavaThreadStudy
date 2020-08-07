package artConcurrentBook.chapter04;

/**
 * 6-5
 */
public class Daemon {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isDaemon());
        Thread thread = new Thread(new DaemonRunner());
        thread.setDaemon(false);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
