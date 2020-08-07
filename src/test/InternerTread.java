package test;

/**
 * Created by linhaibin on 2018/5/17.
 */
public class InternerTread implements Runnable{


	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p/>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		InternerTest tread = new InternerTest();
		System.out.println(tread.test(Thread.currentThread().getName()));
	}
}
