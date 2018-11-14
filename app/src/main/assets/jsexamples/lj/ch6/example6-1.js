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
	