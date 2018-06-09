// Create a thread by implementing Runnable (p 376)
class MyThread376 implements Runnable {
    String thrdName;

    MyThread376(String name) {
        thrdName = name;
    }

    // Entry point of thread.
    public void run() {
        System.out.println(thrdName + " starting.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrdName + ", count is " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thrdName + " interrupted.");
        }
        System.out.println(thrdName + " terminating.");
    }

    // ==================================================================
    public static void useThreads() {
        System.out.println("Main thread starting.");

        MyThread376 mt = new MyThread376("Child #1");
        Thread newThrd = new Thread(mt);
        newThrd.start();

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
        // Main thread starting.
        // .Child #1 starting.
        // ...In Child #1, count is 0
        // ....In Child #1, count is 1
        // ....In Child #1, count is 2
        // ....In Child #1, count is 3
        // ...In Child #1, count is 4
        // ....In Child #1, count is 5
        // ....In Child #1, count is 6
        // ...In Child #1, count is 7
        // ....In Child #1, count is 8
        // ....In Child #1, count is 9
        // Child #1 terminating.
        // ............Main thread ending.
    }
}

class MyThread380 implements Runnable {
    Thread thrd;

    MyThread380(String name) {
        thrd = new Thread(this, name);
    }

    // A factory method that creates and starts a thread.
    public static MyThread380 createAndStart(String name) {
        MyThread380 myThrd = new MyThread380(name);
        myThrd.thrd.start();
        return myThrd;
    }

    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrd.getName() + ", count is " + count);

            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " terminating.");

    }

    // ==================================================================

    public static void threadVariations() {
        System.out.println("Main thread starting.");
        MyThread380 mt = MyThread380.createAndStart("Child #1");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
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
}

class MyThread386 implements Runnable {
    Thread thrd;

    MyThread386(String name) {
        thrd = new Thread(this, name);
    }

    // A factory method that creates and starts a thread.
    public static MyThread386 createAndStart(String name) {
        MyThread386 myThrd = new MyThread386(name);
        myThrd.thrd.start(); // start the thread
        return myThrd;
    }

    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrd.getName() + ", count is " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " terminating.");
    }

    // ==================================================================

    public static void moreThreads() {
        System.out.println("Main thread starting.");
        MyThread386 mt1 = MyThread386.createAndStart("Child #1");
        MyThread386 mt2 = MyThread386.createAndStart("Child #2");
        MyThread386 mt3 = MyThread386.createAndStart("Child #3");
        do {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        } while (mt1.thrd.isAlive() || mt2.thrd.isAlive() || mt3.thrd.isAlive());
        System.out.println("Main thread ending.");
    }
    // Main thread starting.
    // Child #1 starting.
    // .Child #3 starting.
    // Child #2 starting.
    // ...In Child #1, count is 0
    // In Child #2, count is 0
    // In Child #3, count is 0
    // ....In Child #1, count is 1
    // In Child #2, count is 1
    // In Child #3, count is 1
    // ....In Child #2, count is 2
    // In Child #1, count is 2
    // In Child #3, count is 2
    // ...In Child #1, count is 3
    // In Child #3, count is 3
    // In Child #2, count is 3
    // ....In Child #2, count is 4
    // In Child #1, count is 4
    // In Child #3, count is 4
    // ....In Child #1, count is 5
    // In Child #2, count is 5
    // In Child #3, count is 5
    // ...In Child #2, count is 6
    // In Child #3, count is 6
    // In Child #1, count is 6
    // ....In Child #2, count is 7
    // In Child #1, count is 7
    // In Child #3, count is 7
    // ....In Child #3, count is 8
    // In Child #1, count is 8
    // In Child #2, count is 8
    // ....In Child #2, count is 9
    // Child #2 terminating.
    // In Child #1, count is 9
    // In Child #3, count is 9
    // Child #3 terminating.
    // Child #1 terminating.
    // Main thread ending.
}

// Use join(). (p 390)
class MyThread390 implements Runnable {
    Thread thrd;

    MyThread390(String name) {
        thrd = new Thread(this, name);
    }

    public static MyThread390 createAndStart(String name) {
        MyThread390 myThrd = new MyThread390(name);
        myThrd.thrd.start();
        return myThrd;
    }

    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrd.getName() + ", count is " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " terminating.");
    }

    // ==================================================================

    public static void joinThreads() {
        System.out.println("Main thread starting.");
        MyThread390 mt1 = MyThread390.createAndStart("Child #1");
        MyThread390 mt2 = MyThread390.createAndStart("Child #2");
        MyThread390 mt3 = MyThread390.createAndStart("Child #3");

        try {
            mt1.thrd.join(); // wait until thread is finished
            System.out.println("Child #1 joined.");
            mt2.thrd.join(); // wait until thread is finished
            System.out.println("Child #2 joined.");
            mt3.thrd.join(); // wait until thread is finished
            System.out.println("Child #3 joined.");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread ending.");
        // Main thread starting.
        // Child #1 starting.
        // Child #2 starting.
        // Child #3 starting.
        // In Child #1, count is 0
        // In Child #3, count is 0
        // In Child #2, count is 0
        // In Child #2, count is 1
        // In Child #1, count is 1
        // In Child #3, count is 1
        // In Child #3, count is 2
        // In Child #1, count is 2
        // In Child #2, count is 2
        // In Child #1, count is 3
        // In Child #3, count is 3
        // In Child #2, count is 3
        // In Child #3, count is 4
        // In Child #1, count is 4
        // In Child #2, count is 4
        // In Child #2, count is 5
        // In Child #3, count is 5
        // In Child #1, count is 5
        // In Child #3, count is 6
        // In Child #1, count is 6
        // In Child #2, count is 6
        // In Child #3, count is 7
        // In Child #1, count is 7
        // In Child #2, count is 7
        // In Child #1, count is 8
        // In Child #3, count is 8
        // In Child #2, count is 8
        // In Child #3, count is 9
        // Child #3 terminating.
        // In Child #1, count is 9
        // Child #1 terminating.
        // In Child #2, count is 9
        // Child #1 joined.
        // Child #2 terminating.
        // Child #2 joined.
        // Child #3 joined.
        // Main thread ending.
    }
}

class Priority implements Runnable {
    int count;
    Thread thrd;

    static boolean stop = false;
    static String currentName;

    // Construct a new thread.
    Priority(String name) {
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    public void run() {
        // System.out.println(thrd.getName() + " starting.");
        do {
            count++;
            if (currentName.compareTo(thrd.getName()) != 0) {
                currentName = thrd.getName();
                // System.out.println("In " + currentName);
            }
        } while (stop == false && count < 10_000_000);
        stop = true;
        // System.out.println("\n" + thrd.getName() + " terminating.");
    }

    // ==================================================================

    public static void priorityDemo() {
        Priority mt1 = new Priority("High Priority");
        Priority mt2 = new Priority("Low Priority");
        Priority mt3 = new Priority("Normal Priority #1");
        Priority mt4 = new Priority("Normal Priority #2");
        Priority mt5 = new Priority("Normal Priority #3");

        mt1.thrd.setPriority(Thread.NORM_PRIORITY + 2); // Higher Priority
        mt2.thrd.setPriority(Thread.NORM_PRIORITY - 2); // Lower Priority
        // mt3, 4, 5 are at the default priority

        mt1.thrd.start();
        mt2.thrd.start();
        mt3.thrd.start();
        mt4.thrd.start();
        mt5.thrd.start();

        try {
            mt1.thrd.join();
            mt2.thrd.join();
            mt3.thrd.join();
            mt4.thrd.join();
            mt5.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("High priority thread counted to " + mt1.count);
        System.out.println("Low priority thread counted to " + mt2.count);
        System.out.println("1st normal priority thread counted to " + mt3.count);
        System.out.println("2nd normal priority thread counted to " + mt4.count);
        System.out.println("3rd normal priority thread counted to " + mt5.count);

        // High priority thread counted to 10000000
        // Low priority thread counted to 1052033
        // 1st normal priority thread counted to 6439924
        // 2nd normal priority thread counted to 7233112
        // 3rd normal priority thread counted to 6643825
    }
}

// Use synchronize to control access. (p 397)
class SumArray397 {
    private int sum;

    synchronized int SumArray397(int nums[]) {
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);
            try {
                Thread.sleep(10); // allow task-switch
            } catch (InterruptedException p) {
                System.out.println("Thread interrupted.");
            }
        }
        return sum;
    }

}

class MyThread397 implements Runnable {
    Thread thrd;
    static SumArray397 sa = new SumArray397();
    int a[];
    int answer;

    MyThread397(String name, int nums[]) {
        thrd = new Thread(this, name);
        a = nums;
    }

    public static MyThread397 createAndStart(String name, int nums[]) {
        MyThread397 myThrd = new MyThread397(name, nums);
        myThrd.thrd.start();
        return myThrd;
    }

    public void run() {
        int sum;
        System.out.println(thrd.getName() + " starting.");
        answer = sa.SumArray397(a);
        System.out.println("Sum for " + thrd.getName() + " is " + answer);
        System.out.println(thrd.getName() + " terminating.");
    }

    // ==================================================================

    public static void sync() {
        int a[] = {1, 2, 3, 4, 5};

        MyThread397 mt1 = MyThread397.createAndStart("Child #1", a);
        MyThread397 mt2 = MyThread397.createAndStart("Child #2", a);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        // % java Example
        // Child #1 starting.
        // Running total for Child #1 is 1
        // Child #2 starting.
        // Running total for Child #1 is 3
        // Running total for Child #1 is 6
        // Running total for Child #1 is 10
        // Running total for Child #1 is 15
        // Sum for Child #1 is 15
        // Child #1 terminating.
        // Running total for Child #2 is 1
        // Running total for Child #2 is 3
        // Running total for Child #2 is 6
        // Running total for Child #2 is 10
        // Running total for Child #2 is 15
        // Sum for Child #2 is 15
        // Child #2 terminating.
    }
}

// Use a synchronized block to control access to SumArray. (p 400)
class SumArray400 {
    private int sum;

    int SumArray400(int nums[]) { // Here, sumArray() is not synchronized
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("Running total for " + Thread.currentThread().getName() + " is " + sum);
            try {
                Thread.sleep(10); // allow task-switch
            } catch (InterruptedException p) {
                System.out.println("Thread interrupted.");
            }
        }
        return sum;
    }

}

class MyThread400 implements Runnable {
    Thread thrd;
    static SumArray400 sa = new SumArray400();
    int a[];
    int answer;

    MyThread400(String name, int nums[]) {
        thrd = new Thread(this, name);
        a = nums;
    }

    public static MyThread400 createAndStart(String name, int nums[]) {
        MyThread400 myThrd = new MyThread400(name, nums);
        myThrd.thrd.start();
        return myThrd;
    }

    public void run() {
        int sum;
        System.out.println(thrd.getName() + " starting.");

        // synchornize calls to sumArray()
        synchronized (sa) { // Here, calls to sumArray() on sa are synchronized.
            answer = sa.SumArray400(a);
        }
        System.out.println("Sum for " + thrd.getName() + " is " + answer);
        System.out.println(thrd.getName() + " terminating.");
    }

    // ==================================================================

    public static void sync() {
        int a[] = {1, 2, 3, 4, 5};

        MyThread400 mt1 = MyThread400.createAndStart("Child #1", a);
        MyThread400 mt2 = MyThread400.createAndStart("Child #2", a);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
    // % java Example
    // Child #2 starting.
    // Child #1 starting.
    // Running total for Child #2 is 1
    // Running total for Child #2 is 3
    // Running total for Child #2 is 6
    // Running total for Child #2 is 10
    // Running total for Child #2 is 15
    // Running total for Child #1 is 1
    // Sum for Child #2 is 15
    // Child #2 terminating.
    // Running total for Child #1 is 3
    // Running total for Child #1 is 6
    // Running total for Child #1 is 10
    // Running total for Child #1 is 15
    // Sum for Child #1 is 15
    // Child #1 terminating.
}

// Use wait() and notify() to create a ticking clock. (p 403)
class TickTock403 {
    String state; // contains the state of the clock

    synchronized void tick(boolean running) {
        if (!running) { // stop the clock
            state = "ticked";
            notify(); // notify any waiting threads
            return;
        }
        System.out.print("Tick ");
        state = "ticked"; // set the current state to ticked
        notify(); // let tock() run
        try {
            while (!state.equals("tocked"))
                wait(); // wait for tock() to complete
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) { // stop the clock
            state = "tocked";
            notify(); // notify any waiting threads
            return;
        }

        System.out.println("Tock");
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

class MyThread403 implements Runnable {
    Thread thrd;
    TickTock403 ttOb;

    MyThread403(String name, TickTock403 tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
    }

    public static MyThread403 createAndStart(String name, TickTock403 tt) {
        MyThread403 myThrd = new MyThread403(name, tt);
        myThrd.thrd.start(); // start the thread
        return myThrd;
    }

    public void run() {

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
    }

    // ==================================================================

    public static void threadCom() {
        TickTock403 tt = new TickTock403();
        MyThread403 mt1 = MyThread403.createAndStart("Tick", tt);
        MyThread403 mt2 = MyThread403.createAndStart("Tock", tt);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        // Tick Tock
        // Tick Tock
        // Tick Tock
        // Tick Tock
        // Tick Tock
    }
}

// No calls to wait() or notify() (p. 407)
class TickTock407 {
    String state; // contains the state of the clock

    synchronized void tick(boolean running) {
        if (!running) { // stop the clock
            state = "ticked";
            return;
        }
        System.out.print("Tick ");
        state = "ticked"; // set the current state to ticked
    }

    synchronized void tock(boolean running) {
        if (!running) { // stop the clock
            state = "tocked";
            return;
        }

        System.out.println("Tock");
        state = "tocked"; // set the current state to tocked
    }
}

class MyThread407 implements Runnable {
    Thread thrd;
    TickTock407 ttOb;

    MyThread407(String name, TickTock407 tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
    }

    public static MyThread407 createAndStart(String name, TickTock407 tt) {
        MyThread407 myThrd = new MyThread407(name, tt);
        myThrd.thrd.start(); // start the thread
        return myThrd;
    }

    public void run() {

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
    }

    // ==================================================================

    public static void threadCom() {
        TickTock407 tt = new TickTock407();
        MyThread407 mt1 = MyThread407.createAndStart("Tick", tt);
        MyThread407 mt2 = MyThread407.createAndStart("Tock", tt);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
    // % java Example
    // Tick Tick Tick Tick Tick Tock
    // Tock
    // Tock
    // Tock
    // Tock
}

// Suspending, resuming, and stopping a thread.

class MyThread409 implements Runnable {
    Thread thrd;
    boolean suspended;
    boolean stopped;

    MyThread409(String name) {
        thrd = new Thread(this, name);
        suspended = false;
        stopped = false;
    }

    public static MyThread409 createAndStart(String name) {
        MyThread409 myThrd = new MyThread409(name);
        myThrd.thrd.start();
        return myThrd;
    }

    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if ((i % 10) == 0) {
                    System.out.println();
                    Thread.sleep(250);
                }
                // Use synchronized block to check suspended and stopped.
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped) break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " exiting.");
    }

    synchronized void mystop() {
        stopped = true;
        suspended = false;
        notify();
    }

    synchronized void mysuspend() {
        suspended = true;
    }

    synchronized void myresume() {
        suspended = false;
        notify();
    }

    public static void suspend() {
        MyThread409 mt1 = MyThread409.createAndStart("My Thread");
        try {
            Thread.sleep(1000); // let ob1 thread start executing

            mt1.mysuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            mt1.myresume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            mt1.mysuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            mt1.myresume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            mt1.mysuspend();
            System.out.println("Stopping thread.");
            mt1.mystop();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        // wait for thread to finish
        try {
            mt1.thrd.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");

        // My Thread starting.
        // 1 2 3 4 5 6 7 8 9 10
        // 11 12 13 14 15 16 17 18 19 20
        // 21 22 23 24 25 26 27 28 29 30
        // 31 32 33 34 35 36 37 38 39 40
        // Suspending thread.
        // Resuming thread.
        // 41 42 43 44 45 46 47 48 49 50
        // 51 52 53 54 55 56 57 58 59 60
        // 61 62 63 64 65 66 67 68 69 70
        // 71 72 73 74 75 76 77 78 79 80
        // Suspending thread.
        // Resuming thread.
        // 81 82 83 84 85 86 87 88 89 90
        // 91 92 93 94 95 96 97 98 99 100
        // 101 102 103 104 105 106 107 108 109 110
        // 111 112 113 114 115 116 117 118 119 120
        // Stopping thread.
        // My Thread exiting.
        // Main thread exiting.
    }
}

class Example {
    public static void main(String[] args) {
        // MyThread376.useThreads();
        // MyThread380.threadVariations();
        // MyThread386.moreThreads();
        // MyThread390.joinThreads();
        // Priority.priorityDemo();
        // MyThread397.sync();
        // MyThread400.sync();
        // MyThread403.threadCom();
        // MyThread407.threadCom();
        MyThread409.suspend();
    }
}
