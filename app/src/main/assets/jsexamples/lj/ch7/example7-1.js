function f1(xArgument) {
	return xArgument + 3;
}
console.log(f1(5)); // 8
// console.log(xArgument); // ReferenceError: xArgument is not defined
// - The scope of xArgument is the function f1

const xArgument=3;
function f2() {
	console.log(xArgument); // 3
	console.log(y); // 13
}

const y=13;
f2();

// ========================================
// - scope is "hierarchial" and "global scope" is at the base of the tree
// - anything declared in the "global scope" is called a "global"

function greet(user) {
	console.log(`Hello, ${user.name}!`);
}

function getBirthYear(user) {
	return new Date().getFullYear() - user.age;
}

function avoidGlobal() {
	let george = {name:"George", age:4};
	greet(george); // Hello, George!
	console.log(getBirthYear(george)); // 2014
}

avoidGlobal();

// =======================================
// - "let" and "const" declare identifiers in "block scope"
// - "block" is a list of statements surrounded by curly braces

function blockScopeExample() {
	{ // "standalone block" (not part of a control flow statement)
		const specialNumber = 3;
		console.log(specialNumber); // 3
	}
	// console.log(`outside block; x=${specialNumber}`);
	// ReferenceError: specialNumber is not defined
}

blockScopeExample();

// =======================================
// - a common confusion is variables or constants are used with
// the same name in different scopes

function variableMasking() {
	{ // block 1
		const blueVariable = 'blue';
		console.log(blueVariable); // blue
	}
	console.log(typeof blueVariable); // undefined
	{ // block 2
		const blueVariable = 3;
		console.log(blueVariable); // 3
	}
	console.log(typeof blueVariable); // undefined
}

function variableMasking2() {
	{ // outer block
		let blueVariable = 'blue';
		console.log(blueVariable); // blue
		{ // inner block
			let blueVariable = "red";
			console.log(blueVariable); // red
		}
		console.log(blueVariable); // blue
	}
	console.log(typeof blueVariable); // undefined
}

function variableMasking3() {
	// outer block
	let x = {color:"blue"};
	let y = x;
	let z = 3;
	{ // inner block
		let x = 5; // outer x is masked
		console.log(x); // 5
		console.log(y.color); // blue (y is still in scope)
		y.color = "red";
		console.log(z); // 3
	}
	console.log(x.color); // red (modified inside the inner block)
	console.log(y.color); // red (x and y point to the same object)
}

variableMasking();
variableMasking2();
variableMasking3();
// - variable masking is sometimes called "variable shadowing"
// - scope is hierarchical, forming a "scope chain"

//========================================
// Functions, Closures, and Lexical Scope
// - it's quite common to intentionally define a function in a 
// specific scope so that it explicitly has access to that scope.
// - this is called a "closure" (closing a scope around a function)

function closureExample() {
	let myFunction; // a declared but undefined function
	{ // start of the closure
		let blockVar = 'a';
		myFunction = function() {
			console.log(blockVar);
		}
	}
	myFunction(); // a
	// - no matter where you call "myFunction" it will have
	// access to the identifiers in that closure (viz. blockVar)
}

function closureExample2() {
	let f; // a declared but undefined function
	{ // start of the closure
		let o = {note:'Safe'};
		f = function() {
			return o;
		}
	}
	let oRef = f();
	oRef.note = "Not so safe after all!";
	console.log(oRef); // { note: 'Not so safe after all!' }
	// - functions allow us a window into scopes that are otherwise inaccessible.
}

closureExample();
closureExample2();

//=======================================================
// function expressions allow us to create:
// IIFE (Immediately Invoked Function Expression)
// - An IIFE declares and runs a function immediately

function IIFE_example1() {
	(function() {
		console.log("My first IIFE"); // My first IIFE
	})();
}

function IIFE_example2() {
	// - the advantage of the IIFE is that anything inside it has its own scope,
	// and because it is a function, it can pass something outside of its scope.
	const message = (function() {
		const secret = "I'm a secret!";
		return `The secret is ${secret.length} characters long.`;
	})();
	console.log(message); // The secret is 13 characters long.
}

function IIFE_example3() {
	// reports the number of times it has been called, and cannot be tampered with.
	const f = (function() {
		let count = 0;
		return function() {
			return `I have been called ${++count} time(s).`
		}
	})();
	console.log(typeof f());
	console.log(f());
	// I have been called 1 time(s).
	// I have been called 2 time(s).
}

IIFE_example1();
IIFE_example2();
IIFE_example3();

//=================================================
// Function Scope and Hoisting
// - when you declare a variable with let, it doesn't spring
// into existence until you declare it
// - However, a variable declared with "var" is available
// everywhere in the current scope

function hoistingExample() {
	let var1;
	let var2 = undefined;
	console.log(var1);
	console.log(var2);
	// console.log(undefinedVar); // ReferenceError: undefinedVar is not defined
}

function hoistingExample2() {
	// console.log(x); // ReferenceError: x is not defined
	let x = 3;
	console.log(x); // 3
}

function hoistingExample3() {
	console.log(x); // 3 (x is "hoisted to everywhere in the scope")
	var x = 3;
	console.log(x); // 3
}

hoistingExample();
hoistingExample2();
hoistingExample3();

//=====================================================
// Function Hoisting - like variables declared with "var", function declarations
// are hoisted to the top of their scope, allowing you to call functions before
// they are declared

function functionHoist() {
	f(); // f
	function f() {
		console.log('f');
	}
}

functionHoist();

//=====================================================
// TDZ (temporal dead zone) - variables declared with "let" don't exist
// until you declare them
// - Within a scope, the TDZ for a variable is the code before the variable is declared

function TDZ_example() {
	let tVar;
	if (typeof tVar === undefined) {
		// skip this part
		console.log("skipped"); // in the TDZ of tVar
	}
	tVar = 3;
	console.log(tVar);
}

TDZ_example();

//====================================================
// Strict Mode - prevents implicit globals
// - if you forgot to declare a variable with var, JavaScript will
// declaring "explicitly".  Put to code in strict mode to prevent this.

function strictModeExample() {
	yNotStrict = 31; // no ReferenceError in 'non-strict mode'
	console.log(yNotStrict); // 31
	(function() {
		'use strict'; // applies strict mode for this scope
		// xStrict = 32; // ReferenceError: xString is not defined
	})();
}

strictModeExample();