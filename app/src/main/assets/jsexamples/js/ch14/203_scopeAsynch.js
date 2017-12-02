console.log("=== Scope and Asynchronous Execution (p 203)");

function countDown() {
	console.log("Countdown:");
	for (let i=5; i>=0; i--) { // i is now block-scoped
		console.log(`In the for loop: i = ${i}`);
		setTimeout(function() {
			console.log(i===0 ? "GO!": i);
		}, (5-i)*1000);
	}
	console.log(`Outside the for loop: i = ${typeof i}`);
}
countDown();
/*
=== Scope and Asynchronous Execution (p 203)
Countdown:
In the for loop: i = 5
In the for loop: i = 4
In the for loop: i = 3
In the for loop: i = 2
In the for loop: i = 1
In the for loop: i = 0
Outside the for loop: i = undefined
5
4
3
2
1
GO!
*/