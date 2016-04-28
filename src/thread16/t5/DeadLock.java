package thread16.t5;

/**
 * Description: <br/>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * 
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class A {
	public synchronized void foo(B b) {

		System.out.println("当前线程名: " + Thread.currentThread().getName() + " 进入了A实例的foo方法"); //①
		try {
			Thread.sleep(200);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("当前线程名: " + Thread.currentThread().getName() + " 企图调用B实例的last方法"); //③
		//当bar()中释放了资源之后，接下来就是顺序执行了
		b.last();
		//唤醒一个线程的时候，线程必须要获得该对象的对象级别锁，的如果调用 notify()时没有持有适当的锁，也会抛出 IllegalMonitorStateException。
		synchronized (b) {
			System.out.println("唤醒其他线程");
			b.notifyAll();
		}
	}

	public synchronized void lastA() {
		System.out.println("当前线程名: " + Thread.currentThread().getName() + " 进入了A类的last方法内部");
	}
}

class B {
	public synchronized void bar(A a) {
		System.out.println("当前线程名: " + Thread.currentThread().getName() + " 进入了B实例的bar方法"); //②
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("当前线程名: " + Thread.currentThread().getName() + " 企图调用A实例的lastA方法"); //④
		try {
			// TODO 这里释放的是什么资源？应该是实例b对象;问题：怎样去唤醒该线程
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//这个时候想要去调用a.lastA()，但是lastA方法是实例的同步,foo()和lastA()方法只能同时被一个线程调用
		//这个时候a资源已经被主线程中的init()使用了，在init()方法中使用了a.foo(b)，因为foo()和lastA()方法只能同时被一个线程调用
		System.out.println("aaa");
		a.lastA();
	}

	public synchronized void last() {
		System.out.println("当前线程名: " + Thread.currentThread().getName() + " 进入了B类的last方法内部");
		//下面这两个notify都能成功唤醒副线程
		//notify();
		//this.notify();//问题：这里的this指代哪个？
	}
}

public class DeadLock implements Runnable {
	A a = new A();
	B b = new B();

	public void init() {
		Thread.currentThread().setName("主线程");
		// 调用a对象的foo方法
		a.foo(b);
		System.out.println("进入了主线程之后");
	}

	public void run() {
		Thread.currentThread().setName("副线程");
		// 调用b对象的bar方法
		b.bar(a);
		System.out.println("进入了副线程之后");
	}

	public static void main(String[] args) {
		DeadLock dl = new DeadLock();
		// 以dl为target启动新线程
		new Thread(dl).start();
		// 调用init()方法
		dl.init();
	}
}
