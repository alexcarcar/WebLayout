/*
	Try This 6-2

	Construct a Queue from a Queue.
*/

class Queue {
    // these members are now private
    private char q[]; // this array holds the queue
    private int putloc, getloc; // the put and get indicies

    Queue(int size) {
        q = new char[size]; // allocate memory for queue
        putloc = getloc = 0;
    }

    // Construct a Queue from a Queue
    Queue(Queue ob) {
    	putloc = ob.putloc;
    	getloc = ob.getloc;
    	q = new char[ob.q.length];
    	for (int i=getloc; i<putloc; i++) {
    		q[i] = ob.q[i];
    	}
    }

    // Construct a Queue with initial values.
    Queue(char a[]) {
    	putloc = 0;
    	getloc = 0;
    	q = new char[a.length];
    	for(int i=0; i<a.length; i++) put(a[i]);
    }

    void put(char ch) {
        if (putloc == q.length) {
            return;
        }
        q[putloc++] = ch;
    }

    char get() {
        if (getloc == putloc) {
            return (char) 0;
        }
        return q[getloc++];
    }
}

// Demonstrate the Queue class
class QDemo2 {
    public static void main(String[] args) {
    	// construct 10-element empty queue
    	Queue q1 = new Queue(10);

    	char name[] = {'T', 'o', 'm'};
    	// construct queue from array
    	Queue q2 = new Queue(name);

    	char ch;
    	int i;

    	// put some characters into q1
    	for (i=0; i<10; i++) {
    		q1.put((char) ('A' + i));
    	}

    	// construct queue from another queue
    	Queue q3 = new Queue(q1);

    	// Show the queues.
    	System.out.print("Contents of q1: ");
    	for (i=0; i<10; i++) {
    		ch = q1.get();
    		System.out.print(ch);
    	}
    	System.out.println();
    	System.out.print("Contents of q2: ");
    	for (i=0; i<10; i++) {
    		ch = q2.get();
    		System.out.print(ch);
    	}
    	System.out.println();
    	System.out.print("Contents of q3: ");
    	for (i=0; i<10; i++) {
    		ch = q3.get();
    		System.out.print(ch);
    	}
    	System.out.println();
    }
}

// Contents of q1: ABCDEFGHIJ
// Contents of q2: Tom
// Contents of q3: ABCDEFGHIJ
