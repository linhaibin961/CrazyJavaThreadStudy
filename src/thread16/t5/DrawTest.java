package thread16.t5;

/**
 * Description: <br/>
 * ��վ: <a href="http://www.crazyit.org">���Java����</a> <br/>
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
		// ����һ���˻�
		Account acct = new Account("1234567", 1000);
		String lock = "lock";
		String lock2 = "lock2";
		String lock3 = "lock";
		System.out.println(lock == lock2);
		// ģ�������̶߳�ͬһ���˻�ȡǮ
		new DrawThread("��", acct, 800, lock).start();
		new DrawThread("��", acct, 800, lock).start();
		new DrawThread2("��", acct, 800, lock2).start();
		new DrawThread2("��", acct, 800, lock).start();
	}
}
