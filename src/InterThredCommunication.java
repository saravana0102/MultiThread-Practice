class myThread extends Thread {

	int total = 0;

	public void run() {
		synchronized (this) {
			System.out.println("Child Thread is Calculating");
			for (int i = 1; i <= 100; i++) {
				total += i;
			}
			System.out.println("Child Thread trying to give notification");
		}
	}
}

public class InterThredCommunication {

	public static void main(String[] args) throws InterruptedException{
		myThread t = new myThread();
		t.start();
		synchronized (t) {
			System.out.println("Main Thread Trying to call wait method");
			t.wait();
			System.out.println("Main Thread got a notification");
			System.out.println(t.total);
		}
	}

}
