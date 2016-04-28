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
public class DrawTest {
	public static void main(String[] args) {
		// 创建一个账户
		Account acct = new Account("1234567", 1000);
		String lock = "lock";
		String lock2 = "lock2";
		String lock3 = "lock";
		System.out.println(lock == lock2);
		// 模拟两个线程对同一个账户取钱
		new DrawThread("甲", acct, 800, lock).start();
		new DrawThread("乙", acct, 800, lock).start();
		new DrawThread2("丙", acct, 800, lock2).start();
		new DrawThread2("丁", acct, 800, lock).start();
	}
}
