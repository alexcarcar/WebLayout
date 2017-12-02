console.log("=== Scope and Asynchronous Execution (p 202)");

function countDown() {
	let i; // not we declare let outside of the for loop
	console.log("Countdown:");
	for (i=5; i>=0; i--) {
		console.log(`In the for loop: i = ${i}`);
		setTimeout(function() {
			console.log(i===0 ? "GO!": i);
		}, (5-i)*1000);
	}
	console.log(`Outside the for loop: i = ${i}`);
}
countDown();

// The for loop executes completely, leaving the value -1
// and only then do the callbacks start executing
//
// The problem is when the callbacks start executing i=-1
//
// When we invoke "countDown" we're creating a closure that
// contains the variable i.  All the anonymous callbacks
// all have access to i -- the same i

/*
=== Scope and Asynchronous Execution (p 202)
Countdown:
In the for loop: i = 5
In the for loop: i = 4
In the for loop: i = 3
In the for loop: i = 2
In the for loop: i = 1
In the for loop: i = 0
Outside the for loop: i = -1
-1
-1
-1
-1
-1
-1
*/