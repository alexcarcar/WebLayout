/*
	Try This 6-1

	An improved queue class for characters.
*/

class Queue {
    // these members are now private
    private char q[]; // this array holds the queue
    private int putloc, getloc; // the put and get indicies

    Queue(int size) {
        q = new char[size]; // allocate memory for queue
        putloc = getloc = 0;
    }

    void put(char ch) {
        if (putloc == q.length) {
            System.out.println(" - Queue is full.");
            return;
        }
        q[putloc++] = ch;
    }

    char get() {
        if (getloc == putloc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }
        return q[getloc++];
    }
}

// Demonstrate the Queue class
class QDemo {
    public static void main(String[] args) {
        Queue bigQ = new Queue(100);
        Queue smallQ = new Queue(4);
        char ch;
        int i;

        System.out.println("Using bigQ to store the alphabet.");
        for (i = 0; i < 26; i++) {
            bigQ.put((char) ('A' + i));
        }
        System.out.print("Contents of bigQ: ");
        for (i = 0; i < 26; i++) {
            ch = bigQ.get();
            if (ch != (char) 0) System.out.print(ch);
        }
        System.out.println("\n");

        System.out.println("Using smallQ to generate errors.");
        for (i = 0; i < 5; i++) {
            System.out.print("Attempting to store " + (char) ('Z' - i));
            smallQ.put((char) ('Z' - i));
            System.out.println();
        }
        System.out.println();
        System.out.print("Contents of smallQ: ");
        for (i = 0; i < 5; i++) {
            ch = smallQ.get();
            if (ch != (char) 0) System.out.print(ch);
        }

        Queue test = new Queue(10);
        // test.q[0] = 99;
        // QDemo.java:67: error: q has private access in Queue
        // test.q[0] = 99;
        //      ^
        
        // test.putloc = -100;
        // QDemo.java:71: error: putloc has private access in Queue
        // test.putloc = -100;
        //     ^
    }
}
// Using bigQ to store the alphabet.
// Contents of bigQ: ABCDEFGHIJKLMNOPQRSTUVWXYZ

// Using smallQ to generate errors.
// Attempting to store Z
// Attempting to store Y
// Attempting to store X
// Attempting to store W
// Attempting to store V - Queue is full.


// Contents of smallQ: ZYXW - Queue is empty.
