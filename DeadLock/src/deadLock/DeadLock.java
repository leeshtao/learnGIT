package deadLock;


public class DeadLock {

	public void run(){
		ResourceLockTask rlt = new ResourceLockTask();
		new Thread(rlt, "线程A").start();
		new Thread(rlt, "线程B").start();
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
				System.out.println(Thread.currentThread().getName()+"锁住资源o1,等待资源o2");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println(Thread.currentThread().getName()+"得到资源o2");
				}
			}
		}else {
			flag = true;
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName()+"锁住资源o2,等待资源o1");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println(Thread.currentThread().getName()+"得到资源o1");
				}
			}
		}
	}
	
}