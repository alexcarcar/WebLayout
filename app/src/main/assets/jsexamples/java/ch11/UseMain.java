// Try This 11-2: Controlling the main thread (p 413)

class UseMain {
	public static void main(String[] args) {
		Thread thrd;

		thrd = Thread.currentThread();
		System.out.println("Main thread is called: " + thrd.getName());
		System.out.println("Priority: " + thrd.getPriority());
		System.out.println();

		System.out.println("Setting name and priority.\n");
		thrd.setName("Thread #1");
		thrd.setPriority(Thread.NORM_PRIORITY+3);

		System.out.println("Main thread is now called: " + thrd.getName());
		System.out.println("Priority is now: " + thrd.getPriority());
		// Main thread is called: main
		// Priority: 5

		// Setting name and priority.

		// Main thread is now called: Thread #1
		// Priority is now: 8

		/*
		try {
			thrd.join(); // will never end (waiting for the main thread to end)
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		*/
	}
}