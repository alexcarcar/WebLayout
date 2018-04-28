class Example {

	// Read a character from the keyboard. p (67)
	static void kbIn() throws java.io.IOException {
		char ch;
		System.out.print("Press a key followed by ENTER: ");
		ch = (char) System.in.read(); // get a char
		System.out.println("Your key is: "+ch);
		// Press a key followed by ENTER: t
		// Your key is: t
	}

	// Guess the letter game. (p 68)
	static void guess() throws java.io.IOException {
		char ch, answer = 'K';
		System.out.println("I'm thinking of a letter between A and Z.");
		System.out.print("Can you guess it:");
		ch = (char) System.in.read(); // read a char from the keyboard
		if(ch==answer) System.out.println("** Right **");
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
		for (x=0; x<6; x++) {
			if (x==1)
				System.out.println("x is one");
			else if (x==2)
				System.out.println("x is two");
			else if (x==3)
				System.out.println("x is three");
			else if (x==4)
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
		for (i=0; i<10; i++) {
			switch (i) {
				case 0: System.out.println("i is zero"); break;
				case 1: System.out.println("i is one"); break;
				case 2: System.out.println("i is two"); break;
				case 3: System.out.println("i is three"); break;
				case 4: System.out.println("i is four"); break;
				default: System.out.println("i is five or more"); break;
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
		for (num=1.0; num<100.0; num+=13) {
			sroot = Math.sqrt(num);
			System.out.print("sqrt("+num+")="+sroot);
			rerr = num -(sroot*sroot);
			System.out.println("\terror="+rerr);
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
		int i,j;
		for (i=0,j=10; i<j; i++,j--) {
			System.out.println("i and j: "+i+" "+j);
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
		for (i=0; (char)System.in.read()!='S'; i++) {
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
		int i, sum =0;
		for(i=1;i<=5;sum+=i++);
		System.out.println("Sum is " +sum);
		// Sum is 15 //... = 1+2+3+4+5
	}

	public static void main(String[] args) throws java.io.IOException {
		// kbIn(); guess();
		ladder(); switchDemo(); sqrRoot(); comma();
		// forTest();
		emptyLoop();
	}
}