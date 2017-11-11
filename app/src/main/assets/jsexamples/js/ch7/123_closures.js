console.log("=== closures (p 123)");
// Example 1: a simple example of a closure
let globalFunc; // undefined global function
{
	let blockVar = 'a';
	globalFunc = function() {
		console.log(blockVar);
	}
}
globalFunc(); // a

// Example 2: accessing objects outside of a closure
let fExample; // undefined function
{
	let o = {note: 'Safe'};
	fExample = function() {
		return o;
	}
}
let oRef = fExample();
oRef.note = "Not so safe after all!";
console.log(fExample());

// Example 3: IIFE (immediately invoked function expression)
const message = (function(){
	const secret = "I'm a secret!";
	return `The secret is ${secret.length} characters long.`;
})();
console.log(message);

// Example 4: IIFE (counting number of executions)
const fCount = (function(){
	let count = 0; // is in the closure of the annonymous function below
	return function() {
		return `I have been called ${++count} time(s).`;
	}
})();
console.log(fCount());
console.log(fCount());

console.log("=== function scope and hoisting (p 125)");
// Example 5: hoisting variables
let var1;
let var2 = undefined;
console.log(var1, var2, typeof undefinedVar);
// x; -- will create a runtime error
let x = 3;
console.log(x);

console.log(xVar);
var xVar = 3;
console.log(xVar);

// Example 6: hosting variables
if (xHoisting !== 3) {
	console.log(yHoisting);
	var yHoisting = 5;
	if (yHoisting === 5) {
		var xHoisting = 3;
	}
	console.log(yHoisting);
}
if (xHoisting === 3) {
	console.log(yHoisting);
}

// Example 7: repeated var defintions are allowed
var xRepeat = 3;
if (xRepeat === 3) {
	var xRepeat = 2; // hoisted to the top (does not mask the upper xRepeat variable)
	console.log(xRepeat);
}
console.log(xRepeat);

// Example 8: function scoping
fHoist();
function fHoist() { // like var hoisted to the top of the scope
	console.log('fHoist');
}
//fLetScope(); // creates an undefined error
let fLetScope = function() {
	console.log('fLetScope');
}
/*
=== closures (p 123)
a
{ note: 'Not so safe after all!' }
The secret is 13 characters long.
I have been called 1 time(s).
I have been called 2 time(s).
=== function scope and hoisting (p 125)
undefined undefined 'undefined'
3
undefined
3
undefined
5
5
2
2
fHoist
*/