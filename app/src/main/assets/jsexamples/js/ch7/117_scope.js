console.log("=== scope (p 117)");

function fScope(x) {
	return x + 3; // scope of x is the function fScope
}
console.log(fScope(5), typeof x); // x is not defined