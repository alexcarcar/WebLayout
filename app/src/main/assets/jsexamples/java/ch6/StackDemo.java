class Stack {
    // these members are now private
    private char s[]; // this array holds the stack
    private int putloc, getloc; // the put and get indicies

    Stack(int size) {
        s = new char[size]; // allocate memory for queue
        putloc = 0;
    }

    void push(char ch) {
        if (putloc == s.length) {
            System.out.println(" - Stack is full.");
            return;
        }
        s[putloc++] = ch;
    }

    char pop() {
        if (putloc == 0) {
            System.out.println(" - Stack is empty.");
            return (char) 0;
        }
        return s[--putloc];
    }
}

// Demonstrate the Stack class
class StackDemo {
    public static void main(String[] args) {
        Stack s = new Stack(10);
        s.push('A');
        s.push('l');
        s.push('e');
        s.push('x');
        System.out.println(s.pop()); // x
        System.out.println(s.pop()); // e
        System.out.println(s.pop()); // l
        System.out.println(s.pop()); // A
        System.out.println(s.pop()); //  - Stack is empty.
    }
}
