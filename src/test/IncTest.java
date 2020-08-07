package test;

/**
 * Created by linhaibin on 2018/4/25.
 */
//希望输出是0，但结果几乎每次都不一样
public class IncTest {
    private volatile static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread() {
            @Override
            public void run() {
                for( int j = 0 ; j < 10000 ; j++ ) i++;
            }
        };
        a.start();
        Thread b = new Thread() {
            @Override
            public void run() {
                for( int j = 0 ; j < 10000 ; j++ ) i--;
            }
        };
        b.start();
        a.join();
        b.join();
        Thread.sleep(1000);
        System.out.println(i);
    }
}
