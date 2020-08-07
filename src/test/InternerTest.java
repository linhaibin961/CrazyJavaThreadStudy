package test;

/**
 * Created by linhaibin on 2018/5/17.
 */
public class InternerTest {
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			System.out.println("tread" + i);
			new Thread(new InternerTread(), "tread" + i).start();
		}
	}
	public String test(String str) {
		synchronized (Instance.lockPool.intern(str)){
			try {
				Thread.sleep(1*1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return str + "!!!!";
		}
	}
}
