// functions (p. 103)
function sayHello() {
	console.log("hello");
}
sayHello(); // hello

function getGreeting() {
	return "greeting";
}
console.log(getGreeting()); // greeting
console.log(getGreeting); // [Function: getGreeting]
const f = getGreeting;
console.log(f()); // greeting

const o = {};
o.f = getGreeting;
console.log(o.f()); // greeting

const arr = [1, 2, 3];
arr[1] = getGreeting;
console.log(arr[1]()); // greeting

function avg(a,b) {
	return (a+b)/2;
}
console.log(avg(5,10)); // 7.5

// values v. arguments (p. 106)
function fargs(x) {
	console.log(`inside f: x=${x}`);
	x = 5;
	console.log(`inside f: x=${x} (after assignment)`);
}
let x = 7;
fargs(7);
console.log(`after calling f: x=${x}`)
// inside f: x=7
// inside f: x=5 (after assignment)
// after calling f: x=7

// modifying an object type inside a function (p. 106)
function objectModifier(o) {
	o.message = `set in f (previous value: '${o.message}')`;
}
let o2 = {
	message: "initial value"
};
console.log(`before calling f: o2.message="${o2.message}"`)
objectModifier(o2);
console.log(`after calling f: o2.message="${o2.message}"`)
// before calling f: o2.message="initial value"
// after calling f: o2.message="set in f (previous value: 'initial value')"

// another object modifier experiment (p. 107)
function anotherModifier(o) {
	o.message = "set in f"; // point to the same object outside the function
	o = { // assignment points to a different object
		message: "new object!"
	};
	console.log(`inside f: o.message="${o.message}" (after assignment)`)
}

let anotherObject = {
	message: 'initial value'
};
console.log(`before calling f: anotherObject.message="${anotherObject.message}" (after assignment)`);
anotherModifier(anotherObject);
console.log(`after calling f: anotherObject.message="${anotherObject.message}" (after assignment)`);

// before calling f: anotherObject.message="initial value" (after assignment)
// inside f: o.message="new object!" (after assignment)
// after calling f: anotherObject.message="set in f" (after assignment)

// undefined arguments
function passNothing(x) {
	return `in f: x=${x}`;
}
console.log(passNothing()); // in f: x=undefined

//------------------------------------------------
// Destructuring Arguments (p 108)
function getSentence({subject, verb, object}) {
	return `${subject} ${verb} ${object}`;
}
const oSentence = {subject:"I", verb:"love", object:"JavaScript", extra:72};
console.log(getSentence(oSentence)); // I love JavaScript

// Using the spread operator(...) to collect additional arguments
function addPrefix(prefix, ...words) {
	const prefixedWords = [];
	for (let i=0; i<words.length; i++) {
		prefixedWords[i] = prefix + words[i];
	}
	return prefixedWords;
}
console.log(addPrefix("con", "verse", "vex")); // [ 'converse', 'convex' ]

//------------------------------------------------
// Default Arguments (p 109)
function fDefault(a, b = "default", c = 3) {
	return `${a} - ${b} - ${c}`;
}
console.log(fDefault(5, 6 , 7)); // 5 - 6 - 7
console.log(fDefault(5, 6)); // 5 - 6 - 3
console.log(fDefault(5)); // 5 - default - 3
console.log(fDefault()); // undefined - default - 3

//------------------------------------------------
// Functions as Properties of Objects
const OWallace = {
	name: "Wallace", // primitive property
	bark: function() {return "Woof!";},
}
console.log(OWallace.bark()); // Woof!

//------------------------------------------------
// The this Keyword (p 110)
OWallace.speak = function() {
	return `My name is ${this.name}!`;
}
console.log(OWallace.speak()); // My name is Wallace!

// "this" is bound according to how the funciton is called,
// not where the function is declared.
const speak = OWallace.speak;
console.log(speak === OWallace.speak); // true; both variables refer to the same function
console.log(speak()); // My name is undefined!

//------------------------------------------------
// nested functions and the "this" variable (p 111)
const oAlex = {
	name: 'Alex',
	greetBackwards: function() {
		const self = this; // self preserves "this" in the scope
		function getReversedName() {
			let nameBackwards = '';
			// this is not bound to the object oAlex
			// we get around this by using the "self" variable
			for (let i=self.name.length-1; i>=0; i--) {
				nameBackwards += self.name[i];
			}
			return nameBackwards;
		}
		return `${getReversedName()}`;
	}
}
console.log(oAlex.greetBackwards()); // xelA

//-----------------------------------------------
// assigned name takes precedence (p 113)
const gAssigned = function fFunnyName(stop) {
	if (stop) console.log('fFunnyName stopped');
};
gAssigned(true); // fFunnyName stopped
// fFunnyName(true); // fFunnyName is undefined