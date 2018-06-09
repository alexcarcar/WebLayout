// Try This 11-1: Extend Thread

class MyExtendThread extends Thread {
	MyExtendThread(String name) {
		super(name);
	}

	public void run() {
		System.out.println(getName() + " starting.");
		try {
			for (int count=0; count<10; count++) {
				Thread.sleep(400);
				System.out.println("In " + getName() + ", count is " + count);
			}
		} catch (InterruptedException e) {
			System.out.println(getName() + " interrupted.");
		}
		System.out.println(getName() + " terminating.");
	}
}

class ExtendThread {
	public static void main(String[] args) {
		System.out.println("Main thread starting.");
		MyExtendThread mt = new MyExtendThread("Child #1");
		mt.start();

		for (int i=0; i<50; i++) {
			System.out.print(".");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Main thread interrupted.");
			}
		}
		System.out.println("Main thread ending.");
	}
}

// % java ExtendThread
// Main thread starting.
// .Child #1 starting.
// ...In Child #1, count is 0
// ....In Child #1, count is 1
// ....In Child #1, count is 2
// ...In Child #1, count is 3
// ....In Child #1, count is 4
// ....In Child #1, count is 5
// ....In Child #1, count is 6
// ...In Child #1, count is 7
// ....In Child #1, count is 8
// ....In Child #1, count is 9
// Child #1 terminating.
// ............Main thread ending.