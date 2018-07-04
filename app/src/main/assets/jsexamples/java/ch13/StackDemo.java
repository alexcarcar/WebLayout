interface IGenStack<T> {
    void push(T ch);
    T pop();
}

class StackEmptyException extends Exception {
    public String toString() {
        return "Stack is empty.";
    }
}

class StackFullException extends Exception {
    public String toString() {
        return "Stack is full.";
    }
}

class Stack implements IGenStack<Character> {
    // these members are now private
    private Character s[]; // this array holds the stack
    private int putloc, getloc; // the put and get indicies

    Stack(int size) {
        s = new Character[size]; // allocate memory for queue
        putloc = 0;
    }

    public void push(Character ch) {
        try {
            if (putloc == s.length) {
                throw new StackFullException();
            }
            s[putloc++] = ch;
        } catch(StackFullException e) {
            System.out.println(e);
        }
    }

    public Character pop() {
        try {
            if (putloc == 0) {
                throw new StackEmptyException();
            }
            return s[--putloc];
        } catch(StackEmptyException e) {
            System.out.println(e);
            return null;
        }
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
        System.out.println(s.pop()); // Stack is empty.
        s.push('1');
        s.push('2');
        s.push('3');
        s.push('4');
        s.push('5');
        s.push('6');
        s.push('7');
        s.push('8');
        s.push('9');
        s.push('a');
        s.push('b'); // Stack is full.
        s.push('c'); // Stack is full.
    }
}

// x
// e
// l
// A
// Stack is empty.
// null
// Stack is full.
// Stack is full.
