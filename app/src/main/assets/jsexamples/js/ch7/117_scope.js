console.log("=== scope (p 117)");

// Example 1: function scope
function fScope(x) {
	return x + 3; // scope of x is the function fScope
}
console.log(fScope(5), typeof x); // x is not defined

// Example 2: lexical versus dynamic scoping
function fLexical1() {
	console.log('one');
}

function fLexical2() {
	console.log('two');
}
fLexical2();
fLexical1();
fLexical2();

// Example 3: lexical scoping
const xLexical = 3;
function fLexical3() {
	console.log(xLexical); // this will work
	console.log(typeof yLexical);
}
const yLexical = 3;
fLexical3();

/*
=== scope (p 117)
8 'undefined'
two
one
two
3
number
*/