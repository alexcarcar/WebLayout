class Example {

    // Read a character from the keyboard. p (67)
    static void kbIn() throws java.io.IOException {
        char ch;
        System.out.print("Press a key followed by ENTER: ");
        ch = (char) System.in.read(); // get a char
        System.out.println("Your key is: " + ch);
        // Press a key followed by ENTER: t
        // Your key is: t
    }

    // Guess the letter game. (p 68)
    static void guess() throws java.io.IOException {
        char ch, answer = 'K';
        System.out.println("I'm thinking of a letter between A and Z.");
        System.out.print("Can you guess it:");
        ch = (char) System.in.read(); // read a char from the keyboard
        if (ch == answer) System.out.println("** Right **");
        else {
            System.out.print("...Sorry, you're ");
            // a nested if
            if (ch < answer) System.out.println("too low");
            else System.out.println("too high");
        }
        // I'm thinking of a letter between A and Z.
        // Can you guess it:J
        // ...Sorry, you're too low

        // I'm thinking of a letter between A and Z.
        // Can you guess it:K
        // ** Right **
    }

    // Demonstrate an if-else-if ladder. (p 70)
    static void ladder() {
        int x;
        for (x = 0; x < 6; x++) {
            if (x == 1)
                System.out.println("x is one");
            else if (x == 2)
                System.out.println("x is two");
            else if (x == 3)
                System.out.println("x is three");
            else if (x == 4)
                System.out.println("x is four");
            else
                System.out.println("x is not between 1 and 4");

        }
        // x is not between 1 and 4
        // x is one
        // x is two
        // x is three
        // x is four
        // x is not between 1 and 4
    }

    static void switchDemo() {
        int i;
        for (i = 0; i < 10; i++) {
            switch (i) {
                case 0:
                    System.out.println("i is zero");
                    break;
                case 1:
                    System.out.println("i is one");
                    break;
                case 2:
                    System.out.println("i is two");
                    break;
                case 3:
                    System.out.println("i is three");
                    break;
                case 4:
                    System.out.println("i is four");
                    break;
                default:
                    System.out.println("i is five or more");
                    break;
            }
        }
        // i is zero
        // i is one
        // i is two
        // i is three
        // i is four
        // i is five or more
        // i is five or more
        // i is five or more
        // i is five or more
        // i is five or more
    }

    // Show square roots of 1 to 99 and the rounding error.
    static void sqrRoot() {
        double num, sroot, rerr;
        for (num = 1.0; num < 100.0; num += 13) {
            sroot = Math.sqrt(num);
            System.out.print("sqrt(" + num + ")=" + sroot);
            rerr = num - (sroot * sroot);
            System.out.println("\terror=" + rerr);
        }
        // sqrt(1.0)=1.0   error=0.0
        // sqrt(14.0)=3.7416573867739413   error=0.0
        // sqrt(27.0)=5.196152422706632    error=0.0
        // sqrt(40.0)=6.324555320336759    error=-7.105427357601002E-15
        // sqrt(53.0)=7.280109889280518    error=0.0
        // sqrt(66.0)=8.12403840463596     error=-1.4210854715202004E-14
        // sqrt(79.0)=8.888194417315589    error=0.0
        // sqrt(92.0)=9.591663046625438    error=1.4210854715202004E-14
    }

    // Use commas in a for statement. (p 79)
    static void comma() {
        int i, j;
        for (i = 0, j = 10; i < j; i++, j--) {
            System.out.println("i and j: " + i + " " + j);
        }
        // i and j: 0 10
        // i and j: 1 9
        // i and j: 2 8
        // i and j: 3 7
        // i and j: 4 6
    }

    // Loop until an S is typed. (p 79)
    static void forTest() throws java.io.IOException {
        int i;
        System.out.println("Press S to stop.");
        for (i = 0; (char) System.in.read() != 'S'; i++) {
            System.out.println("Pass #" + i);
        }
        // Press S to stop.
        // T
        // Pass #0
        // Pass #1
        // Pass #2
        // ER
        // Pass #3
        // Pass #4
        // Pass #5
        // Pass #6
        // S
    }

    // The body of a loop can be empty. (p 81)
    static void emptyLoop() {
        int i, sum = 0;
        for (i = 1; i <= 5; sum += i++) ;
        System.out.println("Sum is " + sum);
        // Sum is 15 //... = 1+2+3+4+5
    }

    // Declare loop control variable inside the for.
    static void forVar() {
        int sum = 0;
        int fact = 1;

        // compute the factorial of the numbers through 5
        for (int i = 1; i <= 5; i++) {
            sum += i;
            fact *= i;
        }
        System.out.println("Sum is " + sum);
        System.out.println("Factorial is " + fact);
        // Sum is 15
        // Factorial is 120
    }

    static void whileDemo() {
        char ch;
        // print the alphabet using a while loop
        ch = 'a';
        while (ch <= 'z') {
            System.out.print(ch);
            ch++;
        }
        System.out.println();
        // abcdefghijklmnopqrstuvwxyz
    }

    // Compute integer powers of 2.
    static void power() {
        int e;
        int result;
        for (int i = 0; i < 10; i++) {
            result = 1;
            e = i;
            while (e > 0) {
                result *= 2;
                e--;
            }
            System.out.println("2^" + i + "=" + result);
        }
        // 2^0=1
        // 2^1=2
        // 2^2=4
        // 2^3=8
        // 2^4=16
        // 2^5=32
        // 2^6=64
        // 2^7=128
        // 2^8=256
        // 2^9=512
    }

    // Guess the letter game, 4th version (p 85)
    static void guessTheLetter() throws java.io.IOException {
        char ch, ignore, answer = 'K';
        do {
            System.out.println("I'm thinking of a letter between A and Z.");
            System.out.println("Can you guess it: ");

            // read a character
            ch = (char) System.in.read();

            // discard any other characters in the input buffer
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');
            if (ch == answer) System.out.println("*** Right ***");
            else {
                System.out.print("...Sorry, you're too ");
                if (ch < answer) System.out.println("low");
                else System.out.println("high");
                System.out.println("Try again!\n");
            }
        } while (answer != ch);
        // I'm thinking of a letter between A and Z.
        // Can you guess it:
        // M
        // ...Sorry, you're too high
        // Try again!

        // I'm thinking of a letter between A and Z.
        // Can you guess it:
        // D
        // ...Sorry, you're too low
        // Try again!

        // I'm thinking of a letter between A and Z.
        // Can you guess it:
        // K
        // *** Right ***
    }

    // using break to exit a loop. (p 90)
    static void breakDemo() {
        int num;
        num = 100;

        // loop while i-squared is less than num
        for (int i = 0; i < num; i++) {
            if (i * i >= num) break; // terminate loop if i*i >= 100
            System.out.print(i + " ");
        }
        System.out.println("Loop complete.");
        //0 1 2 3 4 5 6 7 8 9 Loop complete.
    }

    // Read input until q is received.
    static void breakUntilQ() throws java.io.IOException {
        char ch;
        for (; ; ) {
            ch = (char) System.in.read(); // get a char
            if (ch == 'q') break;
        }
        // adsf q
    }

    // Using break with nested loops.
    static void breakWithNestedLoops() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Outer loop count: " + i);
            System.out.print("\tInner loop count: ");
            int t = 0;
            while (t < 100) {
                if (t == 10) break; // terminate loop if t is 10
                System.out.print(t + " ");
                t++;
            }
            System.out.println();
        }
        System.out.println("Loops complete.");
        // Outer loop count: 0
        //         Inner loop count: 0 1 2 3 4 5 6 7 8 9
        // Outer loop count: 1
        //         Inner loop count: 0 1 2 3 4 5 6 7 8 9
        // Outer loop count: 2
        //         Inner loop count: 0 1 2 3 4 5 6 7 8 9
        // Loops complete.
    }

    // Using break with a label.
    static void breakWithALabel() {
        int i;
        for (i = 1; i < 4; i++) {
            one:
            {
                two:
                {
                    three:
                    {
                        System.out.println("\ni is " + i);
                        if (i == 1) break one;
                        if (i == 2) break two;
                        if (i == 3) break three;

                        // this is never reached
                        System.out.println("won't print");
                    }
                    System.out.println("After block three.");
                }
                System.out.println("After block two.");
            }
            System.out.println("After block one.");
        }
        System.out.println("After for.");
        // i is 1
        // After block one.

        // i is 2
        // After block two.
        // After block one.

        // i is 3
        // After block three.
        // After block two.
        // After block one.
        // After for.
    }

    // Another example of using break with a label.
    static void anotherBreakWithLabel() {
        done:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    System.out.println(k + " ");
                    if (k == 5) break done; // jump to done
                }
                System.out.println("After the k loop"); // won't execute
            }
            System.out.println("After the j loop"); // won't execute
        }
        System.out.println("After the i loop");
        // 0
        // 1
        // 2
        // 3
        // 4
        // 5
        // After the i loop
    }

    // Where you put a label is important. (p 94)
    static void whereYouPutTheLabelIsImportant() {
        int x = 0, y = 0;
        // here, put label before for statement.
        stop1:
        for (x = 0; x < 5; x++) {
            for (y = 0; y < 5; y++) {
                if (y == 2) break stop1;
                System.out.println("x and y: " + x + " " + y);
            }
        }
        System.out.println();
        // x and y: 0 0
        // x and y: 0 1

        // now, put label immediately before {
        for (x = 0; x < 5; x++)
            stop2:{
                for (y = 0; y < 5; y++) {
                    if (y == 2) break stop2;
                    System.out.println("x and y: " + x + " " + y);
                }
            }
        System.out.println();
        // x and y: 0 0
        // x and y: 0 1
        // x and y: 1 0
        // x and y: 1 1
        // x and y: 2 0
        // x and y: 2 1
        // x and y: 3 0
        // x and y: 3 1
        // x and y: 4 0
        // x and y: 4 1
    }

    /*
    // This program contains an error.
    static void breakErr() {
        one:
        for (int i = 0; i < 3; i++) {
            System.out.print("Pass " + i + ": ");
        }
        for (int j = 0; j < 100; j++) {
            if (j == 10) break one; // WRONG
            System.out.print(j + " ");
        }
		// Example.java:400: error: undefined label: one
		//             if (j == 10) break one; // WRONG
		//                          ^
		// 1 error
    }*/

    // Use continue.
    static void continueDemo() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 != 0) continue; // skip odd numbers
            System.out.print(i + " ");
        }
        System.out.println();
        // 0 2 4 6 8 10 12 14 16 18
    }

    // Use continue with a label.
    static void continueToLabel() {
        outerLoop:
        for (int i = 1; i < 10; i++) {
            System.out.print("\nOuter loop pass " + i + ", Inner loop: ");
            for (int j = 1; j < 10; j++) {
                if (j == 5) continue outerLoop; // continue to outer loop
                System.out.print(j);
            }
        }
        // Outer loop pass 1, Inner loop: 1234
        // Outer loop pass 2, Inner loop: 1234
        // Outer loop pass 3, Inner loop: 1234
        // Outer loop pass 4, Inner loop: 1234
        // Outer loop pass 5, Inner loop: 1234
        // Outer loop pass 6, Inner loop: 1234
        // Outer loop pass 7, Inner loop: 1234
        // Outer loop pass 8, Inner loop: 1234
        // Outer loop pass 9, Inner loop: 1234
    }

    // Use nested loops to find factors of numbers
    static void findFactors() {
        for (int i = 2; i <= 12; i++) {
            System.out.print("Factors of " + i + ": ");
            for (int j = 2; j < i; j++)
                if ((i % j) == 0) System.out.print(j + " ");
            System.out.println();
        }
        // Factors of 3:
        // Factors of 4: 2
        // Factors of 5:
        // Factors of 6: 2 3
        // Factors of 7:
        // Factors of 8: 2 4
        // Factors of 9: 3
        // Factors of 10: 2 5
        // Factors of 11:
        // Factors of 12: 2 3 4 6
    }

    public static void main(String[] args) throws java.io.IOException {
        // kbIn(); guess();
        ladder();
        switchDemo();
        sqrRoot();
        comma();
        // forTest();
        emptyLoop();
        forVar();
        whileDemo();
        power();
        // guessTheLetter();
        breakDemo();
        // breakUntilQ();
        breakWithNestedLoops();
        breakWithALabel();
        anotherBreakWithLabel();
        whereYouPutTheLabelIsImportant();
        // breakErr();
        continueDemo();
        continueToLabel();
        findFactors();
    }
}