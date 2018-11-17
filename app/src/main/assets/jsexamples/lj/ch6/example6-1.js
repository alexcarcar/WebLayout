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

//----------------------------------------------
// Arrow Notation
const noArrow = function() {return "hello!";}
const arrow1 = () => "hello!";
console.log(noArrow()); // hello!
console.log(arrow1()); // hello!
const arrow2 = name => `Hello, ${name}!`;
console.log(arrow2("Alex")); // Hello, Alex!
const arrow3 = (a,b) => a+b;
console.log(arrow3(2,9)); // 11

//----------------------------------------------
// Arrow (and inner methods)
const oArrowAlex = {
	name: 'Alex',
	greetBackwards: function() {
		const getReversedName = () => {
			let nameBackwards = '';
			for (var i = this.name.length - 1; i >= 0; i--) {
				nameBackwards += this.name[i];
			}
			return nameBackwards;
		};
		return `Hello ${getReversedName()}`;
	}
};
console.log(oArrowAlex.greetBackwards()); // Hello xelA

//----------------------------------------------
// call, apply, and bind
// - JavaScript allows you to specify what "this" is
// bound to no matter how the function is called
const bruce = {name: "Bruce"};
const madeline = {name: "Madeline"};

// this function isn't associated with any object,
// yet it's using 'this'!
function greet() {
	return `Hello, I'm ${this.name}!`;
}
console.log(greet()); // Hello, I'm undefined!
console.log(greet.call(bruce)); // Hello, I'm Bruce!
console.log(greet.call(madeline)); // Hello, I'm Madeline!

//----------------------------------------------
// - the first argument to "call" is the value you want
// this to be bound to
// - the remaining arguments become arguments in your function 
function update(birthYear, occupation) {
	this.birthYear = birthYear;
	this.occupation = occupation;
}

update.call(bruce, 1949, 'singer');
update.call(madeline, 1942, 'actress');
console.log(bruce); // { name: 'Bruce', birthYear: 1949, occupation: 'singer' }
console.log(madeline); // { name: 'Madeline', birthYear: 1942, occupation: 'actress' }

//----------------------------------------------
// apply is identical to call, but apply takes arguments as an array
update.apply(bruce, [1955, "actor"]);
update.apply(madeline, [1918, "writer"])
console.log(bruce); // { name: 'Bruce', birthYear: 1955, occupation: 'actor' }
console.log(madeline); // { name: 'Madeline', birthYear: 1918, occupation: 'writer' }

//----------------------------------------------
// using apply to built in Math.min and Math.max functions
const applyArray = [2, 3, -5, 15, 7];
console.log(Math.min.apply(null, applyArray)); // -5
console.log(Math.max.apply(null, applyArray)); // 15

//----------------------------------------------
// with ES6 spread argument you can accomplish the same result as apply
const newBruce = [1940, "martial artist"];
update.call(bruce, ...newBruce);
console.log(bruce); // { name: 'Bruce', birthYear: 1940, occupation: 'martial artist' }
console.log(Math.min(...applyArray)); // -5
console.log(Math.max(...applyArray)); // 15

//----------------------------------------------
// bind allows you to permanently associate a value for "this" with the a function
const updateBruce = update.bind(bruce);
updateBruce(1904, "actor");
console.log(bruce); // { name: 'Bruce', birthYear: 1904, occupation: 'actor' }
updateBruce.call(madeline, 1274, "king");
console.log(bruce); // { name: 'Bruce', birthYear: 1274, occupation: 'king' }
console.log(madeline); // { name: 'Madeline', birthYear: 1918, occupation: 'writer' }

//----------------------------------------------
// bind also allows you to permanently bind other arguments
const updateBruce1949 = update.bind(bruce, 1949);
updateBruce1949("singer");
console.log(bruce); // { name: 'Bruce', birthYear: 1949, occupation: 'singer' }
