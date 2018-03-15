package thread16.t5;

/**
 * Description: <br/>
 * ��վ: <c href="http://www.crazyit.org">���Java����</c> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class C {
    public synchronized void foo(D d) {

        System.out.println("��ǰ�߳���: " + Thread.currentThread().getName() + " ������Cʵ����foo����"); //��
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("��ǰ�߳���: " + Thread.currentThread().getName() + " ��ͼ����Dʵ����lastD����"); //��
        //��bar()���ͷ�����Դ֮�󣬽���������˳��ִ����
        d.lastD();
        System.out.println("d.lastD() ���óɹ���");
        //����һ���̵߳�ʱ���̱߳���Ҫ��øö���Ķ��󼶱�������������� notify()ʱû�г����ʵ�������Ҳ���׳� IllegalMonitorStateException��
        synchronized (d) {
            System.out.println("���������߳�");
            d.notifyAll();
        }
    }

    public synchronized void lastC() {
        System.out.println("��ǰ�߳���: " + Thread.currentThread().getName() + " ������C���lastC�����ڲ�");
    }
}

class D {
    public synchronized void bar(C c) {
        System.out.println("��ǰ�߳���: " + Thread.currentThread().getName() + " ������Dʵ����bar����"); //��
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("��ǰ�߳���: " + Thread.currentThread().getName() + " ��ͼ����Cʵ����lastC����"); //��
        try {
            // TODO �����ͷŵ���ʲô��Դ��Ӧ����ʵ��b����;���⣺����ȥ���Ѹ��߳�
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //���ʱ����Ҫȥ����c.lastC()������lastA������ʵ����ͬ��,foo()��lastC()����ֻ��ͬʱ��һ���̵߳���
        //���ʱ��a��Դ�Ѿ������߳��е�init()ʹ���ˣ���init()������ʹ����c.foo(d)����Ϊfoo()��lastC()����ֻ��ͬʱ��һ���̵߳���
        System.out.println("aaa");
        c.lastC();
    }

    public synchronized void lastD() {
        System.out.println("��ǰ�߳���: " + Thread.currentThread().getName() + " ������D���lastD�����ڲ�");
        //����������notify���ܳɹ����Ѹ��߳�
        //notify();
        //this.notify();//���⣺�����thisָ���ĸ���
    }
}

public class DeadLock1 implements Runnable {
    C c = new C();
    D d = new D();

    public static void main(String[] args) {
        DeadLock1 dl = new DeadLock1();
        // ��dlΪtarget�������߳�
        new Thread(dl).start();
        // ����init()����
        dl.init();
    }

    public void init() {
        Thread.currentThread().setName("���߳�");
        // ����a�����foo����
        c.foo(d);
        System.out.println("���������߳�֮��");
    }

    public void run() {
        Thread.currentThread().setName("���߳�");
        // ����b�����bar����
        d.bar(c);
        System.out.println("�����˸��߳�֮��");
    }
}
