import java.io.*;

class TickTock {
    String state; // contains the state of the clock

    synchronized void tick(boolean running) throws InterruptedException {
        if (!running) { // stop the clock
            state = "ticked";
            notify(); // notify any waiting threads
            return;
        }
        System.out.print("Tick ");
    	Thread.sleep(500);
        state = "ticked"; // set the current state to ticked
        notify(); // let tock() run
        try {
            while (!state.equals("tocked"))
                wait(); // wait for tock() to complete
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    synchronized void tock(boolean running) throws InterruptedException {
        if (!running) { // stop the clock
            state = "tocked";
            notify(); // notify any waiting threads
            return;
        }

        System.out.println("Tock");
    	Thread.sleep(500);
        state = "tocked"; // set the current state to tocked

        notify();  // let tick() run
        try {
            while (!state.equals("ticked"))
                wait(); // wait for tick to complete
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }
}

class MyThread implements Runnable {
    Thread thrd;
    TickTock ttOb;

    MyThread(String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
    }

    public static MyThread createAndStart(String name, TickTock tt) {
        MyThread myThrd = new MyThread(name, tt);
        myThrd.thrd.start(); // start the thread
        return myThrd;
    }

    public void run() {

    	try {
	        if (thrd.getName().compareTo("Tick") == 0) {
	            for (int i = 0; i < 5; i++) {
	                ttOb.tick(true);
	            }
	            ttOb.tick(false);
	        } else {
	            for (int i = 0; i < 5; i++) {
	                ttOb.tock(true);
	            }
	            ttOb.tock(false);
	        }
	    } catch (InterruptedException e) {
	    	System.out.println("Interrupted.");
	    }
    }

}

class TickTockDemo {
	public static void main(String[] args) throws InterruptedException {
	    TickTock tt = new TickTock();
	    MyThread mt1 = MyThread.createAndStart("Tick", tt);
	    MyThread mt2 = MyThread.createAndStart("Tock", tt);

	    try {
	        mt1.thrd.join();
	        mt2.thrd.join();
	    } catch (InterruptedException e) {
	        System.out.println("Main thread interrupted.");
	    }
	}
}

// Tick Tock
// Tick Tock
// Tick Tock
// Tick Tock
// Tick Tock
