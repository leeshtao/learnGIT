package deadLock;


public class DeadLock {

	public void run(){
		ResourceLockTask rlt = new ResourceLockTask();
		new Thread(rlt, "�߳�A").start();
		new Thread(rlt, "�߳�B").start();
	}

	public static void main(String[] args) {
		new DeadLock().run();
	}
}

class ResourceLockTask implements Runnable{

	private Object o1 = new Object();
	private Object o2 = new Object();
	private boolean flag = true;
	@Override
	public void run() {
		if (flag) {
			flag = false;
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName()+"��ס��Դo1,�ȴ���Դo2");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println(Thread.currentThread().getName()+"�õ���Դo2");
				}
			}
		}else {
			flag = true;
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName()+"��ס��Դo2,�ȴ���Դo1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println(Thread.currentThread().getName()+"�õ���Դo1");
				}
			}
		}
	}
	
}