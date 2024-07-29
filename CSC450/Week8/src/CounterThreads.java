import java.lang.Thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterThreads extends Thread {
	public enum ThreadType {
		COUNT_UP,
		COUNT_DOWN
	}
	
	private ThreadType type;
	private Lock lock;
	public static int counter = 0;
	
	public CounterThreads(ThreadType type, Lock lock) {
		this.type = type;
		this.lock = lock;
	}
	
	public void run() {
		if (type != null) {
			switch (type) {
			case COUNT_UP:
				this.countUp();
				break;
			case COUNT_DOWN:
				this.countDown();
				break;
			default:
				System.out.println("Error: type of thread is invalid.");
				break;
			}
		}
	}
	
	@SuppressWarnings("static-access")
	private void countUp() {
		this.lock.lock();
		System.out.println("Starting count up to 20");
		while(this.counter < 20) {
			this.counter++;
			System.out.println("Increasing count to: " + this.counter);
		}
		this.lock.unlock();
	}
	
	@SuppressWarnings("static-access")
	private void countDown() {
		this.lock.lock();
		System.out.println("Starting count down to 20");
		while(this.counter > 0) {
			this.counter--;
			System.out.println("Decreasing count to: " + this.counter);
		}
		this.lock.unlock();
	}
	
	public static void main(String args[]) {
		Lock lock = new ReentrantLock();
		CounterThreads t1 = new CounterThreads(ThreadType.COUNT_UP, lock);
		CounterThreads t2 = new CounterThreads(ThreadType.COUNT_DOWN, lock);
		
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
