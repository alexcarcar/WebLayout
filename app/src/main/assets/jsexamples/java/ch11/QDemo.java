/*
	Try This 9-1
*/

class QueueFullException extends Exception {
    int size;
    QueueFullException(int s) {
        size = s;
    }

    public String toString() {
        return "\nQueue is full. Maximum size is " + size;
    }
}

class QueueEmptyException extends Exception {
    public String toString() {
        return "\nQueue is empty.";
    }
}


class Queue {
    // these members are now private
    private char q[]; // this array holds the queue
    private int putloc, getloc; // the put and get indicies

    Queue(int size) {
        q = new char[size]; // allocate memory for queue
        putloc = getloc = 0;
    }

    synchronized void put(char ch) throws QueueFullException {
        if (putloc == q.length) {
            throw new QueueFullException(q.length);
        }
        q[putloc++] = ch;
    }

    synchronized char get() throws QueueEmptyException {
        if (getloc == putloc) {
            throw new QueueEmptyException();
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

        try {
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
        } catch (QueueFullException | QueueEmptyException e) {
            System.out.println(e);
        }
        try {
            System.out.println();
            System.out.print("Contents of smallQ: ");
            for (i = 0; i < 5; i++) {
                ch = smallQ.get();
                if (ch != (char) 0) System.out.print(ch);
            }
        } catch (QueueEmptyException e) {
            System.out.println(e);
        }
    }
}
// Using bigQ to store the alphabet.
// Contents of bigQ: ABCDEFGHIJKLMNOPQRSTUVWXYZ

// Using smallQ to generate errors.
// Attempting to store Z
// Attempting to store Y
// Attempting to store X
// Attempting to store W
// Attempting to store V
// Queue is full. Maximum size is 4

// Contents of smallQ: ZYXW
// Queue is empty.