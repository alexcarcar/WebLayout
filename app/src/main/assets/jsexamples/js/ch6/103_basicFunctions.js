console.log("=== Basic Functions (p 103)")

function getGreeting() {
	return "Hello world!";
}

function sayHello() {
	console.log(getGreeting());
}

sayHello();
console.log(getGreeting(), getGreeting);
const f = sayHello; // referencing to a function
f(); // calling the function

const o = {};
o.f = sayHello;	// adding a function as a property in an object
o.f();

const arr = [1, 2, 3];
arr[1] = sayHello; // adding a function to an array
arr[1]();


function avg(a,b) {
	return (a+b)/2;
}
console.log(avg(5,10));

function f2(o2) {
	o2.message = "set in f";
	o2 = {
		message: "new object!"
	};
	console.log(`inside f: o2.message="${o2.message}" (after assignment)`);
}

let o2 = {
	message: 'initial value'
};

console.log(`before calling f: o2.message="${o2.message}"`);
f2(o2);
console.log(`before calling f: o2.message="${o2.message}"`);

/*
=== Basic Functions (p 103)
Hello world!
Hello world! function getGreeting() {
        return "Hello world!";
}
Hello world!
Hello world!
Hello world!
7.5
before calling f: o2.message="initial value"
inside f: o2.message="new object!" (after assignment)
before calling f: o2.message="set in f"
*/